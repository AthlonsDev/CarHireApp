import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        main.mainMenu();
        main.selectOption(scanner);
      
    }


    private void mainMenu() {

        System.out.println("****************Welcome To Car Hire System****************");
        System.out.println("1. Register As A Customer");
        System.out.println("2. See List Of Cars");
        System.out.println("3. Search For a Car");

        
    }

    private void selectOption(Scanner scanner) {
        
        switch (scanner.nextInt()) {

            case 1:
                System.out.println("Register As A Customer");
                RegisterCustomer rc = new RegisterCustomer();
                rc.registerCustomer();
                break;
            case 2:
                System.out.println("See List Of Cars");
                break;
            case 3:
                System.out.println("Search For a Car");
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
    }

}
