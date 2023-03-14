package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Models.Car;

public class CarHandler {

    public boolean updateCar(String update) {
        List<String> cars = new ArrayList<>();
        // update file with new value
        // read file
        cars = readCSV();

        // update value
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).contains(update)) {
                System.out.println("Car found + " + cars.get(i));
                // replace  "Available" with "Unavailable"
                if(update.contains("Available"))
                    update = update.replace("Available", "Unavailable");
                else
                    return false;
                cars.set(i, update);
            }
        }

        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            String[] carDetails = car.split(",");
            Car c = new Car(carDetails[0], carDetails[1], carDetails[2], carDetails[3]);
            carList.add(c);
        }
        

        // write to file
        FileUploader fu = new FileUploader();
        fu.saveCar(carList);

        return true;
     
    }

    public List<String> readCSV() {
        List<String> cars = new ArrayList<>();

        // read CSV file with multiple lines
        File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\Cars.csv");
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
