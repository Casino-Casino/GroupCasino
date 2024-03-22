package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.Hi_Lo.HiLoCardGame;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import javax.swing.text.Highlighter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private List<CasinoAccount> casinoAccountList = new ArrayList<>();
    private CasinoAccountManager accountManager;
    private Scanner scanner;

    @Override
    public void run() {
        scanner = new Scanner(System.in);

        System.out.println("Welcome to Aquila Casino!");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    System.out.println("Thanks for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void loginMenu() {
        System.out.println("Enter User Name:");
        String userName = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        if (login(userName, password)) {
            System.out.println("Login Successful..");
            String loggedInUserName = userName;
            loggedInMenu(loggedInUserName);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void loggedInMenu(String loggedInUserName) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Deposit funds");
            System.out.println("2. Get Balance");
            System.out.println("3. Play Games");
            System.out.println("4. Logout");

            int choiceLoggedIn = scanner.nextInt();
            scanner.nextLine();
            switch (choiceLoggedIn) {
                case 1:
                    System.out.println("Enter the amount");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    depositFunds(loggedInUserName, amount);
                    break;
                case 2:
                    displayBalance(loggedInUserName);
                    break;
                case 3:
                    playGames();
                    break;
                case 4:
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }
    }

    public Casino() {
        this.accountManager = new CasinoAccountManager();
    }

    public void createAccount() {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        System.out.println("Please enter your first name:");
        String firstname = scanner.nextLine();

        System.out.println("Please enter your last name:");
        String lastname = scanner.nextLine();

        System.out.println("Please enter your birthday (YYYY-MM-DD):");
        String stringDate = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate;
        try {
            birthdate = sdf.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Please enter your initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        CasinoAccount account = new CasinoAccount(username, password, firstname, lastname, birthdate, initialBalance);
        this.accountManager.registerAccount(account);

        casinoAccountList.add(account);
    }

    public boolean login(String userName, String password) {
        return accountManager.findAccount(userName, password) != null;
    }

    public void depositFunds(String username, double amount) {
        CasinoAccount account = accountManager.findAccount(username);
        if (account != null) {
            account.depositFunds(amount);
            System.out.println("Funds deposited successfully. Current balance: " + account.getBalance());
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayBalance(String username) {
        CasinoAccount account = accountManager.findAccount(username);
        if (account != null) {
            System.out.println(account.getFirstName() + ", your account balance is: " + account.getBalance());
        } else {
            System.out.println("User not found.");
        }
    }

    public void playGames() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Choose a game to play:");
            System.out.println("1. Roulette");
            System.out.println("2. HiLo");



            // Add options for other games here *******************************************



            int gameChoice = scanner.nextInt();
            scanner.nextLine();
            switch (gameChoice) {
                case 1:
                    System.out.println("Welcome to Roulette!");
                    RouletteGame rouletteGame = new RouletteGame();
                    rouletteGame.startGame(casinoAccountList);
                    break;
                case 2:
                    System.out.println("Welcome to HiLo");
                    HiLoCardGame hiLo = new HiLoCardGame(this);
                    hiLo.startGame(casinoAccountList);
                    break;


                // Add cases for other games here *******************************************




                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            // Ask if the player wants to play another game
            System.out.println("Do you want to play another game? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Returning to main menu...");
                continuePlaying = false;
                return;
            }
        }
    }

}
