package FileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Models.User;

import java.util.ArrayList;

public class FileUploader {
    
    public void SaveCustomer(String username, String password) {
        // save the username and password to a JSON file

        User user = new User("username", "password", "", "", "");
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("username", username);
        userMap.put("password", password);
        userMap.put("viewedCars", "");
        userMap.put("savedCars", "");
        userMap.put("hiredCars", "");

        String fileName = username;
        String filePath = "C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\";

        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName + ".json");
            fileWriter.write(userMap.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}




