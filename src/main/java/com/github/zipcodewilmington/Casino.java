package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.CasinoPlayerInterface;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.HeadsOrTails.HeadsOrTails;
import com.github.zipcodewilmington.casino.games.Hi_Lo.HiLoCardGame;
import com.github.zipcodewilmington.casino.games.Trivia.TriviaGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private List<CasinoAccount> casinoAccountList = new ArrayList<>();
    private CasinoAccountManager accountManager;
    private Scanner scanner;
    private CasinoAccount casinoAccount;

    @Override
   public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Aquila Casino!");

        while(true){
            System.out.println("Choose an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    this.createAccount();
                    break;
                case 2:
                    System.out.println("Enter User Name:");
                    String userName = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String password = scanner.nextLine();
                    if(this.login(userName,password)){
                        System.out.println("Login Successful..");
                        String loggedInUserName = userName;
                       loop: while(true){
                            System.out.println("Choose an option:");
                            System.out.println("1. Deposit funds");
                            System.out.println("2. Get Balance");
                            System.out.println("3. Play Games");
                            System.out.println("4. Logout");
                            int choiceLoggedIn = scanner.nextInt();
                            scanner.nextLine();
                            switch(choiceLoggedIn){
                                case 1:
                                    System.out.println("Enter the amount");
                                    double amount = scanner.nextDouble();
                                    scanner.nextLine();
                                    depositFunds(loggedInUserName, amount);
                                    break;
                                case 2:
                                    for(CasinoAccount account : this.casinoAccountList){
                                        if(account.getUserName().equals(userName) && account.getPassword().equals(password)){
                                        System.out.println(account.getFirstName()+" your account balance is: "+account.getBalance());
                                        }
                                    }
                                    break;
                                case 3:
                                    playGames();
                                    break;
                                case 4:
                                    System.out.println("Logged out successfully!");
                                    break loop;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid choice.");
                            }
                        }
                    }else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Thanks for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
//        String arcadeDashBoardInput;
//        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
//        do {
//            arcadeDashBoardInput = getArcadeDashboardInput();
//            if ("select-game".equals(arcadeDashBoardInput)) {
//                String accountName = console.getStringInput("Enter your account name:");
//                String accountPassword = console.getStringInput("Enter your account password:");
//                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
//                boolean isValidLogin = casinoAccount != null;
//                if (isValidLogin) {
//                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
//                    if (gameSelectionInput.equals("SLOTS")) {
//                        play(new SlotsGame(), new SlotsPlayer());
//                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
//                        play(new NumberGuessGame(), new NumberGuessPlayer());
//                    } else {
//                        // TODO - implement better exception handling
//                        String errorMessage = "[ %s ] is an invalid game selection";
//                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
//                    }
//                } else {
//                    // TODO - implement better exception handling
//                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
//                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
//                }
//            } else if ("create-account".equals(arcadeDashBoardInput)) {
//                console.println("Welcome to the account-creation screen.");
//                String accountName = console.getStringInput("Enter your account name:");
//                String accountPassword = console.getStringInput("Enter your account password:");
//                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
//                casinoAccountManager.registerAccount(newAccount);
//            }
//        } while (!"logout".equals(arcadeDashBoardInput));
    }

//    private String getArcadeDashboardInput() {
//        return console.getStringInput(new StringBuilder()
//                .append("Welcome to the Arcade Dashboard!")
//                .append("\nFrom here, you can select any of the following options:")
//                .append("\n\t[ create-account ], [ select-game ]")
//                .toString());
//    }
//
//    private String getGameSelectionInput() {
//        return console.getStringInput(new StringBuilder()
//                .append("Welcome to the Game Selection Dashboard!")
//                .append("\nFrom here, you can select any of the following options:")
//                .append("\n\t[ SLOTS ], [ NUMBERGUESS ]")
//                .toString());
//    }
//
//    private void play(Object gameObject, Object playerObject) {
//        GameInterface game = (GameInterface)gameObject;
//        CasinoPlayerInterface player = (CasinoPlayerInterface)playerObject;
//        game.add(player);
//        game.run();
//    }

    public Casino() {
        this.casinoAccountList = new ArrayList<>();
        this.accountManager = new CasinoAccountManager();
        this.scanner = new Scanner(System.in);
    }

    public List<CasinoAccount> getCasinoAccountList() {
        return this.casinoAccountList;
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
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
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
        this.casinoAccountList.add(account);

    }

    public boolean login(String userName, String password) {
        for(CasinoAccount account: this.casinoAccountList){
            if(account.getUserName().equals(userName) && account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void depositFunds(String username, double amount){
        System.out.println(this.casinoAccountList);
        for(CasinoAccount account : this.casinoAccountList){
            if(account.getUserName().equals(username)){
                account.depositFunds(amount);
                System.out.println("Funds deposited successfully. Current balance: "+ account.getBalance());
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void playGames(){
        while(true){
            System.out.println("Choose an option:");
            System.out.println("1. Heads or Tails");
            System.out.println("2. Trading Day");
            System.out.println("3. Craps");
            System.out.println("4. Roulette");
            System.out.println("5. Trivia");
            System.out.println("6. Hi or Lo");
            System.out.println("7. Leave the Tables");
            int gameChoice = scanner.nextInt();
            switch(gameChoice){
                case 1:
                    System.out.println("Welcome To Heads or Tails!");
                    HeadsOrTails.startGame();
                    break;
                case 2:
                    System.out.println("Welcome To Trading Day!");
                    //TradingDay.startGame();
                    break;
                case 3:
                    System.out.println("Welcome To Craps!");
                    CrapsGame.startGame();
                    break;
                case 4:
                    System.out.println("Welcome To Roulette!");
                    RouletteGame.startGame();
                    break;
                case 5:
                    System.out.println("Welcome To Trivia!");
                    TriviaGame.startGame();
                    break;
                case 6:
                    System.out.println("Welcome To Hi or Lo!");
                    HiLoCardGame.startGame();
                    break;
                case 7:
                    System.out.println("\n\t\tOKAY COOL GO AHEAD AND LEAVE\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }

    }
}
