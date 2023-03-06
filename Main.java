import java.util.Scanner;

public class Main {

    public static boolean isLoggedIn = false;
    public static String username = "";
    
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        main.mainMenu(scanner);
        // main.selectOption(scanner);
      
    }


    private void mainMenu(Scanner scanner) {

        if(!isLoggedIn) {// main menu if not logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. See List Of Cars");
            System.out.println("4. Search For a Car");
            System.out.println("5. Exit");
            selectOption(scanner);
        }
        else {// main menu if logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Profile");
            System.out.println("2. See List Of Cars");
            System.out.println("3. Search For a Car");
            System.out.println("4. Exit");
            selectOption(scanner);
        }

        
    }

    private void selectOption(Scanner scanner) {
    
        if(!isLoggedIn) {
            switch (scanner.nextInt()) {

            case 1:
                System.out.println("Register As A New User");
                authController(scanner); // register new user
                mainMenu(scanner); // return to main menu
                break;
            case 2:
                System.out.println("Login Existing User");
                isLoggedIn = loginController(scanner); // login existing user and set isLoggedIn to true if login is successful
                mainMenu(scanner); // return to main menu
                break;
            case 3:
                System.out.println("See List Of Cars");
                CarList cl = new CarList(); 
                cl.ShowCars(); 
                break;
            case 4:
                System.out.println("Search For a Car");
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
        } else {
            switch (scanner.nextInt()) {

            case 1:
                System.out.println("Profile");
                UserProfile up = new UserProfile();
                up.ProfileMenu(username);
                break;
            case 2:
                System.out.println("See List Of Cars");
                CarList cl = new CarList();
                cl.ShowCars();
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

    private void searchCar(Scanner scanner) {
        System.out.println("Enter Car Make");
        String make = scanner.nextLine();
        System.out.println("Enter Car Model");
        String model = scanner.nextLine();
        System.out.println("Enter Car Year");
        String year = scanner.nextLine();
        System.out.println("Enter Car Color");
        String color = scanner.nextLine();
        System.out.println("Enter Car Price");
        String price = scanner.nextLine();
        CarList cl = new CarList();
        // cl.SearchCar(make, model, year, color, price);
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

}
