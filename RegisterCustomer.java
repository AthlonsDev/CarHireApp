import java.util.Scanner;

import FileHandler.FileUploader;
import FileHandler.ValidateUser;
import Models.User;


public class RegisterCustomer extends User implements InputCheck {

    public RegisterCustomer(String username, String password, String viewedCars, String savedCars, String hiredCars) {
        super(username, password, viewedCars, savedCars, hiredCars);

    }

    String _username = " ";
    String _password = " ";
    
    public boolean registerCustomer() {
        System.out.println("Register new User");

        Scanner input = new Scanner(System.in);

        // System.out.println("Enter 0 to exit program");
        // if(input.nextInt() == 0)
        //     System.exit(0);

        EnterUsername(input);
   
        EnterPassword(input);
        
        // save the username and password to a JSON file
        FileUploader fileManager = new FileUploader();

        fileManager.SaveCustomer(_username, _password); // saves the username and password to a JSON file

        return Main.isLoggedIn = true;
    }

    private void EnterUsername(Scanner input) {
        System.out.println("Enter your username: ");

        String username = input.nextLine(); // gets the username from the user
        if (checkUsername(username)) {// checks if the username is at least 8 characters long
            setUsername(username); // sets the username to the username entered by the user
            _username = username;
        }
        else { 
            System.out.println("Username must be at least 8 characters long");
            EnterUsername(input);
            
        }

    }

    private void EnterPassword(Scanner input) {

        System.out.println("Enter your password: ");
        String password = input.nextLine(); // gets the password from the user
        if (checkPassword(password)){ // checks if the password is at least 8 characters long and contains numbers and letters
            setPassword(password); // sets the password to the password entered by the user
            _password = password;
        }
        else {
            System.out.println("Password must be at least 8 characters long");
            EnterPassword(input);
        }

    }

    public boolean checkUsername(String username) {

        if(username.length() >= 6 && username.length() <= 20) {
            // checks if the username is already taken
            ValidateUser vu = new ValidateUser();
            boolean isValid = vu.validateUsername(username);
            if (isValid) {
                // Username already present -> go to login
                System.out.println("username already taken");
                LoginCustomer login = new LoginCustomer();
                login.EnterCredentials();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String password) {
        // checks if the password is at least 8 characters long and contains numbers and letters
        if(password.length() >= 8 && password.length() <= 20) {
            if(password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*")) {
                return true;
            }
        }

        return false;
    }

}
