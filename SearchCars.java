import java.util.List;

import Models.Car;

public class SearchCars {
    
    public Car searchForCar(List<String> carList, String searchBy) {
        Car c = null;

        // search for a car by make
            for (String car : carList) {
                if (car.contains(searchBy)) {
                    String[] carDetails = car.split(",");
                    c = new Car(carDetails[0], carDetails[1], carDetails[2], carDetails[3], carDetails[4], carDetails[5], carDetails[6]);
                }
            }
    
        return c;

    }
}
