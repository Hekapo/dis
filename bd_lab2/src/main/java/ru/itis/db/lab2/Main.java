package ru.itis.db.lab2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Client> clients = new ArrayList<>();
    static List<Car> cars = new ArrayList<>();
    static List<Trip> trips = new ArrayList<>();
    static List<Driver> drivers = new ArrayList<>();


    public static void main(String[] args) {
        Client client = new Client();
        Client client2 = new Client();

        Driver driver = new Driver();
        Driver driver2 = new Driver();

        Trip trip = new Trip();
        Trip trip2 = new Trip();

        Car car = new Car();
        Car car2 = new Car();

        client.setClientId(1);
        client.setName("Client1");
        client.setPhone("123456");
        client2.setClientId(2);
        client2.setName("Client2");
        client2.setPhone("1234567");

        car.setCarId(1);
        car.setModel("Kia rio");
        car.setNumber("8080");
        car2.setCarId(2);
        car2.setModel("Ford");
        car2.setNumber("443");

        driver.setDriverId(1);
        driver.setName("Driver1");
        driver.setPhone("9989829012");
        driver.setRating(10);
        driver.setCar(car);
        driver2.setDriverId(2);
        driver2.setName("Driver2");
        driver2.setPhone("888800909");
        driver2.setRating(6);
        driver2.setCar(car2);

        trip.setClient(client);
        trip.setDate("17.12.2002 15:43");
        trip.setDriver(driver);
        trip2.setClient(client2);
        trip2.setDate("17.12.2020 17:11");
        trip2.setDriver(driver2);

        DB db = new DB();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        cars.add(car);
        cars.add(car2);

        drivers.add(driver);
        drivers.add(driver2);

        trips.add(trip);
        trips.add(trip2);

        clients.add(client);
        clients.add(client2);

        db.setCars(cars);
        db.setClients(clients);
        db.setTrips(trips);
        db.setDrivers(drivers);

        String json = gson.toJson(db);
        System.out.println(json);

        searchTrip(client2);


    }

    static void searchTrip(Client client) {
        for (Trip trip : trips) {
            if (trip.getClient() == client) {
                System.out.println(trip);

            }

        }

    }
}
