import java.util.ArrayList;
import java.util.List;
import FileHandler.UsersHandler;
import FileHandler.ValidateUser;
import Models.User;


public class RegisterCustomer extends User implements InputCheck {

    public RegisterCustomer(String username, String password, String savedCars, String hiredCars) {
        super(username, password, savedCars, hiredCars);

    }

    
    public boolean registerCustomer(String username, String password) {
        System.out.println("Register new User");

        boolean flag = false;

        flag = EnterUsername(username);
   
        flag = EnterPassword(password);

        if (flag) {
            UsersHandler userHandler = new UsersHandler();

            User user = new User(username, password, "0", "0");

            List<User> userList = new ArrayList<>();

            userList.add(user);

            userHandler.handleUsers(userList); // saves the username and password to a CSV file
        }

        return flag;
    }

    private boolean EnterUsername(String username) {

        if (checkUsername(username)) {// checks if the username is at least 8 characters long
            setUsername(username); // sets the username to the username entered by the user
            return true;
        }
        else { 
            System.out.println("Username Invalid");
            return false;
            
        }

    }

    private boolean EnterPassword(String password) {

        if (checkPassword(password)){ // checks if the password is at least 8 characters long and contains numbers and letters
            setPassword(password); // sets the password to the password entered by the user
            return true;
        }
        else {
            System.out.println("Password must be at least 8 characters long and contain numbers and letters");
            return false;
        }

    }

    public boolean checkUsername(String username) {

        if(username.length() >= 6 && username.length() <= 20) {
            // checks if the username is already taken
            ValidateUser vu = new ValidateUser();
            boolean isValid = vu.validateUsername(username);
            if (!isValid) {
                // Username already present -> go to login
                System.out.println("username already taken");
                return false;
            } else {
                return true;
            }
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
