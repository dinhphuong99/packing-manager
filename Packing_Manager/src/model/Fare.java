package model;

public class Fare {
    private int ID;
    private FareType fareType;
    private double price = 0.0;

    public Fare(int ID, FareType fareType, float price) {
        this.ID = ID;
        this.fareType = fareType;
        this.price = price;
    }

    public Fare() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public FareType getFareType() {
        return fareType;
    }

    public void setFareType(FareType fareType) {
        this.fareType = fareType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return ID + "," + (fareType!=null?String.valueOf(fareType.getValue()):null )+
                "," + price;
    }

    public String printToConsole(){
        return String.format("%5d%20s%15f",
                this.ID,this.getFareType(),
                (this.getFareType()!=null?String.valueOf(this.getFareType()):" " ),
                this.getPrice());
    }
}
