package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Car;
import Models.User;


public class FileUploader {

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();
    
    public void SaveCustomer(List<User> users) {


        // create an empty file
        String fileName = "Users";
        String filePath = currentPath + "\\Files\\";
        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName + ".csv");
            fileWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
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
        SaveCustomer(users);

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usersList;

    }

    public void saveCar(List<Car> cars) {
        // save the cars list to a CSV file
        String fileName = "Cars";
        String filePath = currentPath + "\\Files\\";
        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName + ".csv");
            for (Car car : cars) {
                fileWriter.write(car.getMake() + ", " + car.getModel() + ", " + car.getPrice() + ", " + car.isHired() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddCarsToFile() {
        
    }

}




