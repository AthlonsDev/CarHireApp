import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

public class RegisterCustomer extends Customer implements InputCheck {

    String _username = " ";
    String _password = " ";
    
    public boolean registerCustomer() {

        Scanner input = new Scanner(System.in);

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
            return true;
        }

        // checks if the username is already taken

        return false;
    }

    public boolean checkPassword(String password) {
        // checks if the password is at least 8 characters long and contains numbers and letters

        if(password.length() >= 8 && password.contains("1") && password.contains("2") && password.contains("3") && password.contains("4") && password.contains("5") && password.contains("6") && password.contains("7") && password.contains("8") && password.contains("9") && password.contains("0")) {
            return true;
        }

        return false;
    }


    // explore the profile like saved cars and other things

}
