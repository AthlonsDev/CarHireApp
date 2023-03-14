import java.util.ArrayList;
import java.util.List;
import FileHandler.CarHandler;

public class CarList {


    public List<String> showCars() {

        // Car car1 = new Car("Audi", "A4", "2019", "$2000", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Audi A4 2019", "");
        // Car car2 = new Car("BMW", "M3", "2019", "$2500", "White", "Petrol", "Automatic", "2.0L", "Sedan", "1000km", "BMW M3 2019", "");
        // Car car3 = new Car("Mercedes", "C200", "2019", "$2800", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Mercedes C200 2019", "");
        // Car car4 = new Car("Toyota", "Corolla", "2019", "$1500", "White", "Petrol", "Automatic", "2.0L", "Sedan", "1000km", "Toyota Corolla 2019", "");
        // Car car5 = new Car("Volkswagen", "Golf", "2019", "$1200", "Black", "Petrol", "Manual", "2.0L", "Sedan", "1000km", "Volkswagen Golf 2019", "");

        // carList.add(car1);
        // carList.add(car2);
        // carList.add(car3);
        // carList.add(car4);
        // carList.add(car5);

        // FileUploader fileUploader = new FileUploader();
        // fileUploader.saveCar(carList);

        String searchBy = "Mercedes";

        // // create a list of cars
        List<String> carList = new ArrayList<>();


        CarHandler carHandler = new CarHandler();
        carList = carHandler.readCSV();

        return carList;

    }
    
}
