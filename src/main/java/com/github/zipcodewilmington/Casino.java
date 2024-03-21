package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.CasinoPlayerInterface;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
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
    private List<CasinoAccount> casinoAccountList;
    private CasinoAccountManager accountManager;
    private Scanner scanner;

    @Override
   public void run() {
        Casino casino = new Casino();
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
                    casino.createAccount();
                    break;
                case 2:
                    System.out.println("Enter User Name:");
                    String userName = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String password = scanner.nextLine();
                    if(casino.login(userName,password)){
                        System.out.println("Login Successful..");
                        while(true){
                            System.out.println("Choose an option:");
                            System.out.println("1. Deposit funds");
                            System.out.println("2. Play Games");
                            System.out.println("3. Logout");
                            int choiceLoggedIn = scanner.nextInt();
                            scanner.nextLine();
                            switch(choiceLoggedIn){
                                System.out.println("Enter the amount");
                            }
                        }
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
        return casinoAccountList;
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
        accountManager.registerAccount(account);
        casinoAccountList.add(account);

    }


    public boolean login(String userName, String password) {
        for(CasinoAccount account: casinoAccountList){
            if(account.getUserName().equals(userName) && account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
