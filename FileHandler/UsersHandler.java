package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.User;

public class UsersHandler {

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();
    
    public void handleUsers(List<User> users) {
        // if file exists, read from it and add the new user to the list
        // if file does not exist, create an empty file
        File file = new File(currentPath + "\\Files\\" + "Users.csv");
        if(file.exists()) {
            updateCustomer(users);
        }
        else {
            createFile();
        }

    }

    private void createFile() {
    // create an empty file
        try {
            FileWriter fileWriter = new FileWriter(currentPath + "\\Files\\" + "Users.csv");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(List<User> users) {
        List<String> usersList = readList();
        // List<Car> user = new ArrayList<>();
        for (String u : usersList) {
            String[] userDetails = u.split(",");
            User c = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
            users.add(c);
        }
        // save the users list to a CSV file
        FileUploader fileUploader = new FileUploader();
        fileUploader.SaveCustomer(users);

    }

    
    private List<String> readList() {

        List<String> usersList = new ArrayList<>();
        File file = new File(currentPath + "\\Files\\" + "Users.csv");
        try (// read from the file and add the new user to the list
        Scanner fileReader = new Scanner(file)) {
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put every line in a list
                usersList.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return usersList;

    }
    
}
