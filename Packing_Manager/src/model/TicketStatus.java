package model;

public enum TicketStatus {
    AVAILABLE(0), UNAVAILABLE(1);


    private  int value;

    private TicketStatus(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }

    public  static TicketStatus from(int value){
        TicketStatus[] tickets = values();
        for (int i = 0; i < tickets.length; ++i){
            if (tickets[i].value == value) {
                return tickets[i];
            }
        }
        throw new IllegalArgumentException("Invalid ticket type value: " + value);
    }
}
