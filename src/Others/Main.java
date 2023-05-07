package Others;

import Documents.Bookstore;
import Accounts.*;
import static Accounts.Users.*;
import Documents.*;
import java.io.*;
import java.util.*;

public abstract class Main implements Serializable {
    
    // States
    Scanner input = new Scanner(System.in);
    HashMap<String, Client> allClients = new HashMap<>();
    HashMap<String, Administrator> allAdministrators = new HashMap<>();
    Client client;
    Administrator administrator;
    Bookstore bookstore;

    
    
    //asldasdasd
    
    //asdasdasd
    // Constructors
    Main(){
    }
    
    // Methods -->
        // --> Client Methods
    private void signClient() {
        System.out.println("--Enter Name to Login-in or Create a New Client Account--");
        client.setName(input.nextLine());
        
        if(!allClients.containsKey(client.getName()))
            allClients.put(client.getName(), new Client(client.getName()));
        else
            client = allClients.get(client.getName());
    }
    
    private void whichToDisplay() {
        System.out.println("Enter --> [Wishlist] | [Library] | [Bookstore] <-- to Display");
        String action = input.nextLine().toUpperCase();
        
        try {
            if(action.contains("RETURN"))
                return;
            else if(action.contains("WISHLIST")) {
                client.getWishlist().stream().forEach(document -> System.out.println(document + " "));
                System.out.println("\n");
            } else if(action.contains("LIBRARY")) {
                client.getLibrary().stream().forEach(document -> System.out.println(document + " "));
                System.out.println("\n");
            } else if(action.contains("BOOKSTORE")) {
                // Add bookstore
            } else {
                System.out.println("Syntax Might be Incorrect: Try Again");
                whichToDisplay();
            }
        } catch(NullPointerException e) {
            System.out.println("Current Collection Is Non-Existent : Try Again");
        }
    }
    
    private ArrayList<Document> whichToSort() {
        System.out.println("Enter --> [Wishlist] | [Library] | [Bookstore] <-- to Display");
        String action = input.nextLine().toUpperCase();
        
        try {
            if(action.contains("WISHLIST"))
                return client.getWishlist();
            else if(action.contains("LIBRARY"))
                return client.getLibrary();
            else if(action.contains("BOOKSTORE"))
                ;// return bookstore.getBookstore();
            else {
                System.out.println("Incorrect Value Entered : Try Again");
                whichToSort();
            }
        } catch(NullPointerException e) {
            System.out.println("Selected Collection Is Non-Existent : Add A Document To Create A Collection");
        }
            return null;
    }
    
    private void whichSortingType() {
        System.out.println("Enter --> [Ascending Price] | [Decreasing Price] "
                + "| [Ascending Rating] | [Decreasing Rating] | "
                + "[Ascending Title] | [Descending Title] <-- Sorting Type");
        String action = input.nextLine().toUpperCase();
        
        try {
            if(action.contains("RETURN"))
                return;
            else if(action.contains("ASCENDING PRICE"))
                whichToSort().sort(sortPriceAscending());
            else if(action.contains("DESCENDING PRICE"))
                whichToSort().sort(sortPriceDescending());
            else if(action.contains("ASCENDING RATING"))
                whichToSort().sort(sortRatingAscending());
            else if(action.contains("DESCENDING RATING"))
                whichToSort().sort(sortRatingDescending());
            else if(action.contains("ASCENDING TITLE"))
                whichToSort().sort(sortTitleAscending());
            else if(action.contains("DESCENDING TITLE"))
                whichToSort().sort(sortTitleDescending());
            else {
                System.out.println("Spelling Mistake : Try Again");
                whichSortingType();
            }
        } catch(Exception e) { //NullPointerException
            System.out.println("Current Collection Is Not Initialized : Add Documents To Sort");;
        }
    }
    
    private void addToBalance() {
        System.out.println("Enter Amount To Add To Your Balance");
        double balance = input.nextDouble();
        client.setBalance( Double.parseDouble(String.format("%.2f", balance)));
    }
        
    private double viewBalance() {
        return client.getBalance();
    }
    
    private void chooseBalance() {
        System.out.println("Enter --> [Add] | [View] <-- To Choose");
        String action = input.nextLine().toUpperCase();
        
        if(action.contains("ADD"))
            addToBalance();
        else if(action.contains("VIEW"))
            viewBalance();
        else {
            System.out.println("Spelling Mistake: Try Again");
            chooseBalance();
        }
    }

    
    private void chooseFourOptions() {
        System.out.println("Enter --> [Display] | [Modifiy] | [Purchase] | [Sort] [Balance] <-- to Choose");
        String action = input.nextLine().toUpperCase();
        
        if(action.contains("DISPLAY"))
            whichToDisplay();
        else if(action.contains("MODIFY"))
            ;
        else if(action.contains("PURCHASE"))
            ;
        else if(action.contains("BALANCE"))
            ;
        else if(action.contains("SORT"))
            whichSortingType();
        else if(action.contains("BALANCE"))
            chooseBalance();
        else {
            System.out.println("Spelling Mistake: Try Again");
            chooseFourOptions();
        }

    }
    
    private void programClient() {
        String run;
        signClient();
        do {
            chooseFourOptions();
            System.out.println("Enter --> [Run] <-- To Continue");
            run = input.nextLine();
        } while(run.contains("RUN"));
    }
    
    void initializeClients() throws FileNotFoundException, IOException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("as.txt")));
    }
    
        // --> Administrator
    private void signAdministrator() {
        System.out.println("--Enter Username to Login-in or Create a New Administrator Account--");
        administrator.setName(input.nextLine());
        
        if(!allAdministrators.containsKey(administrator.getName())) {
            allAdministrators.put(administrator.getName(), new Administrator());
        } else {
            administrator = allAdministrators.get(administrator.getName());
        }
    }
    
    void programAdministrator() {
        String runOrExit;
        do {
            signClient();
            
            
            
            runOrExit = input.nextLine();
        } while(runOrExit.contains("RUN"));
    }
    
        // --> User & Administrator
    public void choseUserType() {
        System.out.print("Choose User Type: ");
        String userType = input.nextLine();
        userType = userType.toLowerCase();
        
        if(userType.contains("client"))
            programClient();
        else if(userType.contains("administrator"))
            programAdministrator();
        else
            choseUserType();
    }


}