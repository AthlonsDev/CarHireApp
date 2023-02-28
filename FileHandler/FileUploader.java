package FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import Models.User;


public class FileUploader {

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();
    
    public void SaveCustomer(String username, String password) {
        // save the username and password to a JSON file

        User user = new User("username", "password", "", "", "");
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("username", username);
        userMap.put("password", password);
        userMap.put("viewedCars", "null");
        userMap.put("savedCars", "null");
        userMap.put("hiredCars", "null");

        String fileName = username;
        String filePath = currentPath + "\\Files\\";

        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName + ".txt");
            fileWriter.write(userMap.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}




