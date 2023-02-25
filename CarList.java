import java.util.HashMap;

import FileHandler.CarHandler;
import Models.Car;

public class CarList {

    public void ShowCars() {

        Car car1 = new Car("Audi", "A4", "2019", "$2000", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Audi A4 2019", "");
        Car car2 = new Car("BMW", "M3", "2019", "$2500", "White", "Petrol", "Automatic", "2.0L", "Sedan", "1000km", "BMW M3 2019", "");
        Car car3 = new Car("Mercedes", "C200", "2019", "$2800", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Mercedes C200 2019", "");
        Car car4 = new Car("Toyota", "Corolla", "2019", "$1500", "White", "Petrol", "Automatic", "2.0L", "Sedan", "1000km", "Toyota Corolla 2019", "");
        Car car5 = new Car("Volkswagen", "Golf", "2019", "$1200", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Volkswagen Golf 2019", "");
    

        // print out all the car objects
        System.out.println(car1.getMake());
        System.out.println(car2.getMake());
        System.out.println(car3.getMake());
        System.out.println(car4.getMake()); 
        System.out.println(car5.getMake());

        String searchBy = "Mercedes";

        // search for a car by make
        if (car1.getMake().equals(searchBy)) {
            System.out.println(car1.getMake() + " " + car1.getModel());
        } else if (car2.getMake().equals(searchBy)) {
            System.out.println(car2.getMake() + " " + car2.getModel());
        } else if (car3.getMake().equals(searchBy)) {
            System.out.println(car3.getMake() + " " + car3.getModel());
        } else if (car4.getMake().equals(searchBy)) {
            System.out.println(car4.getMake() + " " + car4.getModel());
        } else if (car5.getMake().equals(searchBy)) {
            System.out.println(car5.getMake() + " " + car5.getModel());
        } else {
            System.out.println("No car found");
        }
        
    
    }
    
}
