package cinema;

public class Seat {
    private int row;
    private int seatNumber;
    private String available;

    public Seat(int row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.available = "S";
    }
    public String toString() {
        return String.valueOf(available);
    }
    public void setAvailable(String available) {
        this.available = available;
    }
}
