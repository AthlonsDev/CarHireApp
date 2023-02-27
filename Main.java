import java.util.Scanner;

import FileHandler.FileUploader;

public class Main {

    public static boolean isLoggedIn = false;
    
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        main.mainMenu();
        main.selectOption(scanner);
      
    }


    private void mainMenu() {

        if(!isLoggedIn) {// main menu if not logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. See List Of Cars");
            System.out.println("4. Search For a Car");
            System.out.println("5. Exit");
        }
        else {// main menu if logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Profile");
            System.out.println("2. See List Of Cars");
            System.out.println("3. Search For a Car");
            System.out.println("4. Exit");
        }

        
    }

    private void selectOption(Scanner scanner) {
    
        if(!isLoggedIn) {
            switch (scanner.nextInt()) {

            case 1:
                System.out.println("Register As A New User");
                RegisterCustomer rc = new RegisterCustomer(null, null, null, null, null);
                rc.registerCustomer();
                mainMenu();
                break;
            case 2:
                System.out.println("Login Existing User");
                LoginCustomer login = new LoginCustomer();
                login.EnterCredentials();
                mainMenu();
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

}
