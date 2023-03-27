import java.util.ArrayList;
import java.util.List;
import FileHandler.CarHandler;
import FileHandler.FileUploader;
import Models.Car;

public class CarList {

    public void startCarList() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("Audi", "A4", "2019", "$200/day", "Available", "no start time", "no end time");
        Car car2 = new Car("BMW", "M3", "2019", "$250/day", "Available", "no start time", "no end time" );
        Car car3 = new Car("Mercedes", "C200", "2019", "$280/day", "Available", "no start time", "no end time");
        Car car4 = new Car("Toyota", "Corolla", "2019", "$150/day", "Available", "no start time", "no end time");
        Car car5 = new Car("Volkswagen", "Golf", "2019", "$120/day", "Available", "no start time", "no end time");
        Car car6 = new Car("Alfa Romeo", "Giulietta", "2018", "$150/day", "Available", "no start time", "no end time");
        Car car7 = new Car("Honda", "Accord", "2019", "$130/day", "Available", "no start time", "no end time");
        Car car8 = new Car("Renault", "Clio", "2019", "$110/day", "Available", "no start time", "no end time");
        Car car9 = new Car("Ford", "Fiesta", "2016", "$120/day", "Available", "no start time", "no end time");
        Car car10 = new Car("Kia", "EV6", "2022", "$160/day", "Available", "no start time", "no end time");
        Car car11 = new Car("Volvo", "C40", "2021", "$140/day", "Available", "no start time", "no end time");
        Car car12 = new Car("Tesla", "Model 3", "2017", "$180/day", "Available", "no start time", "no end time");
        Car car13 = new Car("Fiat", "500X", "2015", "$120/day", "Available", "no start time", "no end time");
        Car car14 = new Car("Seat", "Arona", "2018", "$120/day", "Available", "no start time", "no end time");
        Car car15 = new Car("Mitsubishi", "Eclipse", "2018", "$150/day", "Available", "no start time", "no end time");



        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
        carList.add(car10);
        carList.add(car11);
        carList.add(car12);
        carList.add(car13);
        carList.add(car14);
        carList.add(car15);
        

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
