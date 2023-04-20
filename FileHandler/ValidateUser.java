package FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidateUser {

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();

    public boolean validateUsername(String user) {

        // check if file exists
        File file = new File(currentPath + "\\Files\\" + "Users.csv");
        if(file.exists()) {
            // username exists
            System.out.println("file exists");
            return true;
        }
        else {
            // username does not exist
            return false;
        }
    }

    public boolean validateUser(String user, String password) {
        
        Map <String, String> users = new HashMap<String, String>();

        // read CSV file with multiple lines
        File file = new File(currentPath + "\\Files\\" + "Users.csv");
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) { // while there is a line
                String data = fileReader.nextLine(); 
                String[] userData = data.split(", "); // split the string at the comma and store it in an array
                users.put(userData[0], userData[1]); // put the username and password in a map
                }
                fileReader.close();
              
                if(users.containsKey(user)) { // check if the username exists in the map
                    System.out.println("username found");
                    if(users.get(user).equals(password)) { // check if the password is identical to the one in the map
                        System.out.println("Authentication Successful");
                        return true;
                    } else {
                        System.out.println("Authentication Failed - Password did not match"); 
                        return false;
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return false;

        } 
}
