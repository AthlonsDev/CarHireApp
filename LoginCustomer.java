import java.util.Scanner;

import FileHandler.ValidateUser;

public class LoginCustomer extends ValidateUser{
    

    public boolean EnterCredentials() {
        System.out.println("Login existing User");
        String username = "";
        String password = "";
        Scanner scanner = new Scanner(System.in);

        // enter username and pass it over
        System.out.println("Enter Username: ");
        username = scanner.nextLine();
        System.out.println("Enter Password: ");
        password = scanner.nextLine();
        
        // validate user
        if(validateUser(username, password)) {
            System.out.println("Login Successful");
            // set isLoggedIn to true
            Main.isLoggedIn = true;
            return true;
        }
        else {
            System.out.println("Login Failed");
            return false;
        }
        
    }
}
