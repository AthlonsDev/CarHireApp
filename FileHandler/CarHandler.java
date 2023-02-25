package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Models.Car;

public class CarHandler {

    public void ReadCar() {

        HashMap<String, String> carMap = new HashMap<String, String>();
        // read the car from the JSON file
        File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\Cars.json");
        // read from the file
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put the content into a hashmap
                String[] split = data.split(",");
                for(String s : split) {
                    String[] split2 = s.split("=");
                    carMap.put(split2[0], split2[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < carMap.size(); i++) {
            System.out.println(carMap.get(i));
        }
    }

    
}
