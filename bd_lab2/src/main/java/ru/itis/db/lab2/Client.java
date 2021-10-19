package ru.itis.db.lab2;

public class Client {
   private int clientId;
   private String phone;
   private String name;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    @Override
    public String toString() {
        return "Client{ " +
                "clientId= " + clientId +
                ", phone= '" + phone + '\'' +
                ", name= '" + name + '\'' +
                '}';
    }
}
