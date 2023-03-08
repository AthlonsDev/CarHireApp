import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isLoggedIn = false;
    public static String username = "";
    
    
    public static void main(String[] args) {
        Main main = new Main();

        main.mainMenu();
        // main.selectOption(scanner);
      
    }


    private void mainMenu() {


        if(!isLoggedIn) {// main menu if not logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. See List Of Cars");
            System.out.println("4. Search For a Car");
            System.out.println("5. Exit");
            selectRegMenu();
        }
        else {// main menu if logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Profile");
            System.out.println("2. See List Of Cars");
            System.out.println("3. Search For a Car");
            System.out.println("4. Exit");
            selectLogMenu();
        }

        
    }

    private void selectRegMenu() {
        // empty list<String>
        List<String> cl = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        if(!isLoggedIn) {
            switch (scanner.nextInt()) {

            case 1:
                System.out.println("Register As A New User");
                authController(); // register new user
                mainMenu(); // return to main menu
                break;
            case 2:
                System.out.println("Login Existing User");
                isLoggedIn = loginController(); // login existing user and set isLoggedIn to true if login is successful
                mainMenu(); // return to main menu
                break;
            case 3:
                System.out.println("See List Of Cars");
                cl = showCars(); 
                mainMenu(); // return to main menu
                break;
            case 4:
                System.out.println("Search For a Car");
                searchCar(cl);
                break;
            case 5:
                System.out.println("Exit");
                // exit program
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Selection");
                break;
            }
        }
    }

    private void selectLogMenu() {
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {

            case 1:
                System.out.println("Profile");
                UserProfile up = new UserProfile();
                up.ProfileMenu(username);
                break;
            case 2:
                System.out.println("See List Of Cars");
                showCars();
                break;
            case 3:
                System.out.println("Search For a Car");
                break;
            case 4:
                System.out.println("Exit");
                // exit program
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Selection");
                break;
            }
    }


    private void authController() {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Username");
        username = sc.nextLine();

        System.out.println("Enter Password");
        String password = sc.nextLine();

        RegisterCustomer rc = new RegisterCustomer(null, null, null, null, null); // pass in null values
        isLoggedIn = rc.registerCustomer(username, password); // set isLoggedIn to true if registration is successful

    }


    private boolean loginController() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username");
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();
        LoginCustomer lc = new LoginCustomer();
        username = lc.loginCustomer(username, password);

        if (username != null)
            isLoggedIn = true; // set isLoggedIn to true if login is successful

        return isLoggedIn;
        
    }

    private List<String> showCars() {
        // get a list of all cars
        CarList cl = new CarList();
        List<String> carList = cl.showCars();

        return carList;
    }

    
    private void searchCar(List<String> carList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search By Make");
        String searchBy = scanner.nextLine();
        SearchCars sc = new SearchCars();
        System.out.println(sc.searchCar(carList, searchBy));

        System.out.println("Would you like to book this car? (Y/N)");
        String book = scanner.nextLine();
        
    }

}
