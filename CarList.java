import java.util.ArrayList;
import java.util.List;
import FileHandler.CarHandler;
import FileHandler.FileUploader;
import Models.Car;

public class CarList {

    public void startCarList() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("Audi", "A4", "2019", "$2000", "Available", "no start time", "no end time");
        Car car2 = new Car("BMW", "M3", "2019", "$2500", "Available", "no start time", "no end time" );
        Car car3 = new Car("Mercedes", "C200", "2019", "$2800", "Available", "no start time", "no end time");
        Car car4 = new Car("Toyota", "Corolla", "2019", "$1500", "Available", "no start time", "no end time");
        Car car5 = new Car("Volkswagen", "Golf", "2019", "$1200", "Available", "no start time", "no end time");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        FileUploader fileUploader = new FileUploader();
        fileUploader.saveCar(carList);
    }


    public List<String> showCars() {

        // // create a list of cars
        List<String> carList = new ArrayList<>();

        CarHandler carHandler = new CarHandler();
        carList = carHandler.readCSV();

        return carList;

    }
    
}
