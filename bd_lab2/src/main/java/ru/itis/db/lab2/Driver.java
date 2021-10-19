package ru.itis.db.lab2;

public class Driver {
    private int driverId;
    private String phone;
    private String name;
    private int rating;
    private Car car;


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{ " +
                "driverId= " + driverId +
                ", phone= '" + phone + '\'' +
                ", name= '" + name + '\'' +
                ", rating= " + rating +
                ", car= " + car +
                '}';
    }
}
