package FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            return true;
        }
        else {
            // username does not exist
            return false;
        }
    }

    public boolean validateUser(String user, String password) {
        
        // read from Users.csv
        List<String> users = new ArrayList<>();

        // read CSV file with multiple lines
        File file = new File(currentPath + "\\Files\\" + "Users.csv");
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put every line in a list
                users.add(data);
                // compare username and password
                // check if username exists
                int index = checkUsername(user, users);
                if(index != -1) {
                    // check if password exists
                    if(checkPassword(password, users, index)) {
                        return true;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    private int checkUsername(String user, List<String> users) {
        // check if username exists
        for (String u : users) {
            if(u.contains(user)) {
                // get index of list
                int index = users.indexOf(u);
                return index;
            }
        }
        return -1;
    }

    private boolean checkPassword(String pass, List<String> users, int index) {
        // check if password is identical to the one in the list
        String[] data = users.get(index).split(", ");
        if(data[1].equals(pass)) {
            return true;
        }
        return false;
    }

    


}
