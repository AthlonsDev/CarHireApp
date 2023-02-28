import java.util.HashMap;

import FileHandler.ProfileHandler;
import FileHandler.ValidateUser;

public class UserProfile {

    private String savedCars, hiredCars, ViewedCars;
    public void ProfileMenu() {
        System.out.println("User Profile Menu");

        // Read from profile file corresponding to username
        ProfileHandler ph = new ProfileHandler(ViewedCars, ViewedCars, ViewedCars, savedCars, hiredCars);

        savedCars = ph.getSavedCars();

    }
}
