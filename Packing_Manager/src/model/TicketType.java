package model;

public enum TicketType {
    SinglePass(0), Monthly(1);

    private  int value;

    private TicketType(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }

    public  static TicketType from(int value){
        TicketType[] tickets = values();
        for (int i = 0; i < tickets.length; ++i){
            if (tickets[i].value == value) {
                return tickets[i];
            }
        }
        throw new IllegalArgumentException("Invalid ticket type value: " + value);
    }
}
