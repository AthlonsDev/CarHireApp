import java.util.Scanner;

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
            System.out.println("1. Login/Register");
            System.out.println("2. See List Of Cars");
            System.out.println("3. Search For a Car");
            System.out.println("4. Exit");
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
        
        switch (scanner.nextInt()) {

            case 1:
                System.out.println("Register As A Customer");
                RegisterCustomer rc = new RegisterCustomer();
                rc.registerCustomer();
                mainMenu();
                break;
            case 2:
                System.out.println("See List Of Cars");
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
