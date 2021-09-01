package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trouble {
    private int id = 0;
    private int idTicket = 0;
    private String description = null;
    private Date date = null;
    private double intoMoney = 0;
    private String solutions = null;

    public Trouble() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(double intoMoney) {
        this.intoMoney = intoMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSolutions() {
        return solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    @Override
    public String toString(){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return id + "," + idTicket +
                "," + description +
                "," + (date!=null?formatter.format(date): null) +
                "," + intoMoney +
                "," + solutions;
    }

    public String printToConsole(){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("%5d%5d%25s%15f%30s",
                this.getId(),this.getIdTicket(),
                (this.getDate()!=null?formatter.format(this.getDate()): " "),
                this.getIntoMoney(), this.getSolutions());
    }
}
