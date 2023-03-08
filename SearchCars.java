import java.util.List;

public class SearchCars {
    
    public String searchCar(List<String> carList, String searchBy) {
        // TODO: search in the carList file and return
        String result = "";
        // search for a car by make
            for (String car : carList) {
                if (car.contains(searchBy)) {
                    System.out.println(car);
                    result = car;

                }
            }
        return result;

    }
}
