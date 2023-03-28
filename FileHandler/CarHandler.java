package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.*;

import Models.Car;

public class CarHandler {

    public boolean updateCar(Car car, int days) {
        List<String> cars = new ArrayList<>();
        // update file with new value
        // read file
        cars = readCSV();

        String update = car.getMake() + "," + car.getModel() + "," + car.getYear() + "," + car.getPrice() + "," + car.isHired() + "," + car.getStartTime() + "," + car.getEndTime();
        System.out.println("Update: " + update);
        // update value
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).contains(update)) {
                System.out.println("Car found " + cars.get(i)); // debug
                // replace  "Available" with "Unavailable"
                if(update.contains("Available")) { // if car is available
                    update = update.replace("Available", "Unavailable");  // change to unavailable
                    // get current time
                    LocalDate today = LocalDate.now(); // get Local Time as start of booking time
                    System.out.println("from: " + today); 
                    LocalDate endBooking = today.plusDays(days); // add days to the current time as end of booking date
                    System.out.println("to: " + endBooking);
                    update = update.replace("no start time", today.toString()); // replace no start time with start time
                    update = update.replace("no end time", endBooking.toString()); // replace no end time with end time
                }
                else
                    return false; // car is already unavailable
                cars.set(i, update); // update the list with the new value
            }
        }

        List<Car> carList = new ArrayList<>();
        for (String car_ : cars) {
            String[] carDetails = car_.split(",");
            Car c = new Car(carDetails[0], carDetails[1], carDetails[2], carDetails[3], carDetails[4], carDetails[5], carDetails[6]);
            carList.add(c);
        }
        

        // write to file
        FileUploader fu = new FileUploader();
        fu.saveCar(carList);

        return true;
     
    }

    public List<String> readCSV() {

        File currentDir = new File("");
        String currentPath = currentDir.getAbsolutePath();

        List<String> cars = new ArrayList<>();

        // read CSV file with multiple lines
        File file = new File(currentPath + "\\Files\\" + "Cars.csv");
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put every line in a list
                cars.add(data);
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }

}
