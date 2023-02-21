package FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ValidateUser {

    public boolean validateUser(String user, String password) {
        HashMap<String, String> userMap = new HashMap<String, String>();

        File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\Customers.json");
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put the content into a hashmap
                String[] split = data.split(",");
                for(String s : split) {
                    String[] split2 = s.split("=");
                    userMap.put(split2[0], split2[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(userMap.get("Username").equals(user) && userMap.get("Password").equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }


}
