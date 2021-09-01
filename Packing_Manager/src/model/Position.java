package model;

public enum Position {
    ADMIN(0), CAR_KEEPER(1), VALET(2);

    private  int value;

    private Position(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public  static Position from(int value){
        Position[] tickets = values();
        for (int i = 0; i < tickets.length; ++i){
            if (tickets[i].value == value) {
                return tickets[i];
            }
        }
        throw new IllegalArgumentException("Invalid fare type value: " + value);
    }
}
