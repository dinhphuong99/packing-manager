package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrossProfit extends Ticket {
    private int ID;
    private int IDTicket;
    private TicketType type;
    private TicketStatus status;
    private Date startDate;
    private Date endDate;
    private int CustomerID = 0;
    private double price = 0;

    public GrossProfit() {
    }

    public GrossProfit(Ticket ticket){
        this.IDTicket = ticket.getId();
        this.type = ticket.getType();
        this.status = ticket.getStatus();
        this.startDate = ticket.getStartDate();
        this.endDate = ticket.getEndDate();
        CustomerID = ticket.getCustomerID();
        this.price = ticket.getPrice();
    }

    public GrossProfit(int ID, int IDTicket,
                       TicketType type, TicketStatus status,
                       Date startDate, Date endDate,
                       int customerID, double price) {
        this.ID = ID;
        this.IDTicket = IDTicket;
        this.type = type;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        CustomerID = customerID;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDTicket() {
        return IDTicket;
    }

    public void setIDTicket(int IDTicket) {
        this.IDTicket = IDTicket;
    }

    @Override
    public TicketType getType() {
        return type;
    }

    @Override
    public void setType(TicketType type) {
        this.type = type;
    }

    @Override
    public TicketStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int getCustomerID() {
        return CustomerID;
    }

    @Override
    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String printToConsole() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("%5d%5d%20s%15s%25s%25s%5d%5f", this.getID(),
                this.getId(), (this.getType() != null ? String.valueOf(this.getType().getValue()) : " "),
                this.getStatus(),
                (this.getStartDate() != null ? formatter.format(this.getStartDate()) : " "),
                (this.getEndDate() != null ? formatter.format(this.getEndDate()) : " "),
                this.getCustomerID(), this.getPrice());
    }

    @Override
    public String toString() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return this.getID() + "," +
                this.getIDTicket() + "," + (this.getType() != null ? String.valueOf(this.getType().getValue()) : " ") + "," +
                this.getStatus().getValue() + "," +
                (this.getStartDate() != null ? formatter.format(this.getStartDate()) : null) + "," +
                (this.getEndDate() != null ? formatter.format(this.getEndDate()) : null) + "," +
                this.getCustomerID() + "," + this.getPrice();
    }
}