package model;

public class Staff {
    private String IDNumber;
    private String name;
    private String phoneNumber;
    private Position position;
    private String userName;
    private String password;
    private double salary;

    public Staff() {
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.IDNumber + "," + name + "," + phoneNumber +","+
                this.getPosition().getValue() + "," +
                userName + "," + password +","+salary;
    }

    public String printfToConsoleAdmin(){
        return String.format("%20s%30s%15s%20s%20s%15s%10f",
                this.IDNumber,this.getName(),this.getPhoneNumber(),
                (this.getPosition() != null ? String.valueOf(this.getPosition()) : " "),
                this.getUserName(),this.getPassword(), this.getSalary());
    }

    public String printfToConsoleStaff(){
        return String.format("%30s%15s%20s%15f",
                this.getName(),this.getPhoneNumber(),
                (this.getPosition() != null ? String.valueOf(this.getPosition()) : " "),
                this.getSalary());
    }
}
