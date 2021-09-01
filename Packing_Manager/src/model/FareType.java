package model;

public enum FareType {
    SINGLE_PASS_FARE(0), MONTH_FARE(1);

    private  int value;

    private FareType(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public  static FareType from(int value){
        FareType[] tickets = values();
        for (int i = 0; i < tickets.length; ++i){
            if (tickets[i].value == value) {
                return tickets[i];
            }
        }
        throw new IllegalArgumentException("Invalid fare type value: " + value);
    }
}
