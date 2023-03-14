import java.util.List;

public class SearchCars {
    
    public String searchForCar(List<String> carList, String searchBy) {


        String result = "";
        // search for a car by make
            for (String car : carList) {
                if (car.contains(searchBy)) {
                    result = car;

                }
            }
        return result;

    }
}
