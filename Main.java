import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("1. Profile");
            System.out.println("2. See List Of Cars");
            System.out.println("3. Search For a Car");
            System.out.println("4. Exit");
            selectLogMenu();
        }

        
    }

    private void selectRegMenu() {

        Scanner scanner = new Scanner(System.in);

        checkInputInt(scanner); // check if input is an integer

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

        checkInputInt(scanner);

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
                System.out.println("list: " + carList);
                findCar(carList);
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

        RegisterCustomer rc = new RegisterCustomer(null, null, null, null); // pass in null values
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
        String searchResult = sc.searchForCar(carList, searchBy);
        System.out.println(searchResult);

        System.out.println("Would you like to book this car? (Y/N)");
        String book = scanner.nextLine();

        if(book.equals("Y") || book.equals("y") || book.equals("Yes") || book.equals("yes")) {
            
            System.out.print("How may days would you like to hire this " + searchBy + " for?");
            int days = scanner.nextInt();

            //book car
            HireCar hc = new HireCar();
            if (hc.hireCar(searchResult, days)) {
                System.out.println("Car Booked for " + days + " days");
            }
            else {
                System.out.println("Car Not Available");
                mainMenu();
            }
            
        }
        else {
            // return to main menu
            mainMenu();
        }
        
    }

    private void checkInputInt(Scanner scanner) {
        //catch exception if user enters a string
        while(!scanner.hasNextInt()) { // while input is not an integer
            System.out.println("Invalid Selection"); // print error message
            scanner.next(); 
        } 
    }


}
