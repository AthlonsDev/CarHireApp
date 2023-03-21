import FileHandler.CarHandler;

public class HireCar {
    
    public boolean hireCar(String carToHire, int days) {

        boolean isHired = false;

        CarHandler carHandler = new CarHandler();

        isHired = carHandler.updateCar(carToHire, days);

        return isHired;
    }
}
