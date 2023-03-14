import FileHandler.CarHandler;

public class HireCar {
    
    public boolean hireCar(String carToHire) {

        boolean isHired = false;

        CarHandler carHandler = new CarHandler();

        isHired = carHandler.updateCar(carToHire);

        return isHired;
    }
}
