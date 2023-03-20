package Models;

public class User {

    // create a model object for the user
    private String username;
    private String password;
    private String savedCars;
    private String hiredCars;

    // Constructor 
    public User(String username, String password, String savedCars, String hiredCars) {
        this.username = username;
        this.password = password;
        this.savedCars = savedCars;
        this.hiredCars = hiredCars;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSavedCars() {
        return savedCars;
    }

    public void setSavedCars(String savedCars) {
        this.savedCars = savedCars;
    }

    public String getHiredCars() {
        return hiredCars;
    }

    public void setHiredCars(String hiredCars) {
        this.hiredCars = hiredCars;
    }
}
