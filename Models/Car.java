package Models;

import java.security.Timestamp;

public class Car {

    
    String make;  // make of the car
    String model; // model of the car
    String year;  // year of the car
    String hired; // if the car is hired
    String price; // price of the car
    String bookingFrom; // time the booking starts
    String bookingTo; // time the booking ends

    // Constructor
    public Car(String make, String model, String year, String price, String hired, String bookingFrom, String bookingTo)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.hired = hired;
        this.price = price;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;



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

    public String isHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartTime() {
        return bookingFrom;
    }

    public void setStartTime(String bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public String getEndTime() {
        return bookingTo;
    }

    public void setEndTime(String bookingTo) {
        this.bookingTo = bookingTo;
    }
    
}
