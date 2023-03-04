package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Models.User;

public class ProfileHandler {


    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();

    public User readProfile(String user) {

        User userObj = new User("username", "password", "", "", "");

        // read from the file in currentPath + "\\Files\\" + user + ".txt"
        try {
            File file = new File(currentPath + "\\Files\\" + user + ".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] dataSplit = data.split(",");
                for(int i = 0; i < dataSplit.length; i++) {
                    System.out.println(dataSplit[i]);
                    String[] dataSplit2 = dataSplit[i].split("=");
                    System.out.println("data from file: " + dataSplit2[0]);
                    if (dataSplit2[0].equals(" username")) {
                        userObj.setUsername(dataSplit2[1]);
                    }
                    else if (dataSplit2[0].equals(" password")) {
                        userObj.setPassword(dataSplit2[1]);
                    }
                    else if (dataSplit2[0].equals("savedCars")) {
                        userObj.setSavedCars(dataSplit2[1]);
                    }
                    else if (dataSplit2[0].equals("hiredCars")) {
                        userObj.setHiredCars(dataSplit2[1]);
                    }
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("username from user obj: " + userObj.getUsername());
        System.out.println("password from user obj: " + userObj.getPassword());

        return userObj;
        // User userObj = new User(userMap.get("username"), userMap.get("password"), userMap.get("viewedCars"), userMap.get("savedCars"), userMap.get("hiredCars")); // create a new user object with the data from the file


    }
    
}
