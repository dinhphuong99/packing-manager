package model;

import sevice.EnterData;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private int id;
    private  TicketType type;
    private TicketStatus status;
    private Date startDate;
    private Date endDate;
    private int CustomerID = 0;
    private double price = 0;

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return id + "," + (type!=null?String.valueOf(type.getValue()):null )+
                "," + status.getValue() +
                "," + (startDate!=null?formatter.format(startDate): null) +
                "," +(endDate!=null?formatter.format(endDate): null) +
                "," + CustomerID +
                "," + price;
    }

    public String printToConsole(){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("%5d%20s%15s%25s%25s%5d%5f",
                this.getId(),(this.getType()!=null?String.valueOf(this.getType()):" " ),
                this.getStatus(),
                (this.getStartDate()!=null?formatter.format(this.getStartDate()): " "),
                (this.getEndDate()!=null?formatter.format(this.getEndDate()): " "),
                this.getCustomerID(), this.getPrice());
    }
}
