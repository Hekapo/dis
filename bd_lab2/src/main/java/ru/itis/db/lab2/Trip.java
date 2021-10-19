package ru.itis.db.lab2;

public class Trip {
    private String date;
    private Client client;

    private Driver driver;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Trip{ " +
                "date= '" + date + '\'' +
                ", client= " + client +
                ", driver= " + driver +
                '}';
    }
}

