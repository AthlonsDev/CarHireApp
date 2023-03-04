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
        File file = new File(currentPath + "\\Files\\" + user + ".txt");
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
        HashMap<String, String> userMap = new HashMap<String, String>();

        // read the file and store the username and password in a hashmap
        try {
            File file = new File(currentPath + "\\Files\\" + user + ".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] dataSplit = data.split(",");
                for(int i = 0; i < dataSplit.length; i++) {
                    System.out.println(dataSplit[i]);
                    String[] dataSplit2 = dataSplit[i].split("=");
                    userMap.put(dataSplit2[0], dataSplit2[1]);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        if(userMap.containsValue(user) && userMap.containsValue(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    


}
