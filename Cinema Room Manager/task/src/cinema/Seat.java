package cinema;

public class Seat {
    private int row;
    private int seatNumber;
    private int price;
    private String available;

    public Seat(int row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.available = "S";
    }
    public String toString() {
        return available;
    }
    public void setAvailable(String available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
