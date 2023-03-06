import java.util.Scanner;

import FileHandler.FileUploader;
import FileHandler.ValidateUser;
import Models.User;


public class RegisterCustomer extends User implements InputCheck {

    public RegisterCustomer(String username, String password, String viewedCars, String savedCars, String hiredCars) {
        super(username, password, viewedCars, savedCars, hiredCars);

    }

    
    public boolean registerCustomer(String username, String password) {
        System.out.println("Register new User");

        boolean flag = false;

        flag = EnterUsername(username);
   
        flag = EnterPassword(username);

        
        
        FileUploader fileManager = new FileUploader();

        fileManager.SaveCustomer(username, password); // saves the username and password to a JSON file

        return true;
    }

    private boolean EnterUsername(String username) {

        if (checkUsername(username)) {// checks if the username is at least 8 characters long
            setUsername(username); // sets the username to the username entered by the user
            return true;
        }
        else { 
            System.out.println("Username must be at least 8 characters long");
            return false;
            
        }

    }

    private boolean EnterPassword(String password) {

        if (checkPassword(password)){ // checks if the password is at least 8 characters long and contains numbers and letters
            setPassword(password); // sets the password to the password entered by the user
            return true;
        }
        else {
            System.out.println("Password must be at least 8 characters long");
            return false;
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
