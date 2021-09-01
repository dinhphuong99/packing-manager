package model;

public class Customer {
    private int id;
    private String name;
    private String phoneNumber;

    public Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getName() + "," + this.phoneNumber;
    }

    public String printToConsole(){
        return String.format("%5d%30s%15s",
                this.getId(),this.getName(),
                this.getPhoneNumber());
    }
}
