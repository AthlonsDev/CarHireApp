package Models;

public class Car {

    String make;  // make of the car
    String model; // model of the car
    String year;  // year of the car
    String price; // price of the car
    String color; // color of the car
    String fuel;  // fuel type of the car
    String transmission; // transmission type of the car
    String engine; // engine type of the car
    String body; // body type of the car
    String mileage; // mileage of the car
    String description; // description of the car
    String image; // image of the car

    public Car(String make, String model, String year, String price, String color, String fuel, String transmission,
            String engine, String body, String mileage, String description, String image) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.fuel = fuel;
        this.transmission = transmission;
        this.engine = engine;
        this.body = body;
        this.mileage = mileage;
        this.description = description;
        this.image = image;
    }

    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
}
