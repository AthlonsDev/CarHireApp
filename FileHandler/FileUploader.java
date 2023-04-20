package FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Models.Car;
import Models.User;


public class FileUploader {

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();
    
    public void SaveCustomer(List<User> users) {

        // save the users list to a CSV file
        try {
            FileWriter fileWriter = new FileWriter(currentPath + "\\Files\\" + "Users.csv");
            for (User user : users) {
                fileWriter.write(user.getUsername() + ", " + user.getPassword() + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


    public void saveCar(List<Car> cars) {
        // save the cars list to a CSV file
        String fileName = "Cars";
        String filePath = currentPath + "\\Files\\";
        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName + ".csv");
            for (Car car : cars) {
                fileWriter.write(car.getMake() + ", " + car.getModel() + ", " + car.getYear() + ", " + car.getPrice() + ", " + car.isHired() + ", " + car.getStartTime() + ", " + car.getEndTime() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




