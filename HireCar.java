import FileHandler.CarHandler;
import Models.Car;

public class HireCar {
    
    public boolean hireCar(Car carToHire, int days) {

        boolean isHired = false;

        CarHandler carHandler = new CarHandler();

        isHired = carHandler.updateCar(carToHire, days);

        System.out.println("Hiring Car");

        return isHired;
    }
}
