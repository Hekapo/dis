package ru.itis.db.lab2;

public class Car {
   private int carId;
   private String model;
   private String number;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{ " +
                "carId= " + carId +
                ", model= '" + model + '\'' +
                ", number= '" + number + '\'' +
                '}';
    }
}
