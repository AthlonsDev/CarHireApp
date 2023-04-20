import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FileHandler.CarHandler;
import Models.Car;

public class Main {

    public static boolean isLoggedIn = false;
    public static String username = "";
    List<String> carList = new ArrayList<>();
    
    public static void main(String[] args) {
        // create list of cars
        CarList car = new CarList();
        car.startCarList();

        Main main = new Main();
        main.mainMenu();
      
    }


    private void mainMenu() {


        if(!isLoggedIn) {// main menu if not logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. See List Of Cars");
            System.out.println("4. Exit");
            selectRegMenu();
        }
        else {// main menu if logged in
            System.out.println("****************Welcome To Car Hire System****************");
            System.out.println("1. See List Of Cars");
            System.out.println("2. Search For a Car");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            selectLogMenu();
        }

        
    }

    private void selectRegMenu() {

        Scanner scanner = new Scanner(System.in);

        checkInt(scanner); // check if input is an integer

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
                carList = showCars(); 
                mainMenu(); // return to main menu
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

    private void selectLogMenu() {
        Scanner scanner = new Scanner(System.in);

        checkInt(scanner);

        switch (scanner.nextInt()) {

            case 1:
                System.out.println("See List Of Cars");
                showCars();
                break;
            case 2:
                System.out.println("Search For a Car");
                System.out.println("list: " + carList);
                findCar(carList);
                break;
            case 3:
                System.out.println("Log Out");
                isLoggedIn = false;
                mainMenu();
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

        RegisterCustomer rc = new RegisterCustomer(null, null); // pass in null values
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
        carList = cl.showCars();

        for (String car : carList) {
            System.out.println(car);
        }
        mainMenu();
        return carList;
    }

    
    private void findCar(List<String> carList) {

        if (carList.isEmpty()) {
            // if carList is empty, get a list of all cars
            carList = showCars();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Make of Car to Search For");
        String searchBy = scanner.nextLine();
        
        SearchCars sc = new SearchCars();
        Car searchResult = sc.searchForCar(carList, searchBy);
        // System.out.println(searchResult.toString());
        System.out.println(searchResult.getMake() + " " + searchResult.getModel());

        // Check if car is available
        if(searchResult.isHired().equals(" Available")) {
            System.out.println("This Car is Available");
            bookCar(searchResult);
        }
        else {
            System.out.println("This Car is not Available Until " + searchResult.getEndTime());

            mainMenu();
        }
        
    }

    private void bookCar(Car searchResult) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to book this car? (Y/N)");
        String book = scanner.nextLine();

        if(book.equals("Y") || book.equals("y") || book.equals("Yes") || book.equals("yes")) {
            
            System.out.println("How many days would you like to hire this " + searchResult.getMake() + " for?");
            int days = scanner.nextInt();
            // checkInt();

            // check price per day of car and calculate total price
            String priceString = searchResult.getPrice();
            priceString = priceString.substring(2, priceString.indexOf("/"));
            int price = Integer.parseInt(priceString);
            System.out.println(price);
            double totalPrice = price * days;
            System.out.println("Total Price: " + totalPrice);

            //enter payment information and method
            System.out.println("Please enter your payment information");
            int card = scanner.nextInt();

            if (enterPayment(card)) {
            //book car
            HireCar hc = new HireCar();
                if (hc.hireCar(searchResult, days)) {
                    System.out.println("Car Booked for " + days + " days");
                    mainMenu();
                }
                else {
                    System.out.println("Car Not Available");
                    mainMenu();
                }
            } else {
                System.out.println("Payment falied");
                mainMenu();
            }
        }
        else {
            // return to main menu
            mainMenu();
        }
    }


    private boolean enterPayment(int card) {        
        
        PaymentHandler ph = new PaymentHandler();
        
        if (!ph.handlePaymentRequest(card)) {
            return false;
        }
        return true;
    }

    private void checkInt(Scanner scanner) {
        //catch exception if user enters a string when an int is required
        while(!scanner.hasNextInt()) { // while input is not an integer
            System.out.println("Invalid Selection"); // print error message
            scanner.next(); 
        } 
    }


}
