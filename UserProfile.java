import java.util.HashMap;
import java.util.Scanner;

import FileHandler.ProfileHandler;
import FileHandler.ValidateUser;
import Models.User;

public class UserProfile {

    private String savedCars, hiredCars, ViewedCars;
    public void ProfileMenu(String username) {
        System.out.println("User Profile Menu");      

        // Read from profile file corresponding to username
        ProfileHandler ph = new ProfileHandler();

        // get the user object
        User user = ph.readProfile(username);

        System.out.println(user.getUsername());

        ViewProfile(user);

    }

    public void ViewProfile(User user) {

        // create a tuple of the user object
        System.out.println("Username \t Password \t Saved Cars \t Hired Cars \t Viewed Cars");
        System.out.println(user.getUsername() + "\t" + user.getPassword() + "\t" + user.getSavedCars().length() + "\t" + user.getHiredCars().length() + "\t".length());

        // System.out.println("Username: " + user.getUsername());
        // System.out.println("Password: " + user.getPassword());
        // System.out.println("Saved Cars: " + user.getSavedCars());
        // System.out.println("Hired Cars: " + user.getHiredCars());
        // System.out.println("Viewed Cars: " + user.getViewedCars());
    }
}
