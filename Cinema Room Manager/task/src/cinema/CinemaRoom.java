package cinema;

public class CinemaRoom {

    private int numberOfRows;
    private int numberOfSeats;
    private Seat[][] hall;
    public CinemaRoom(int numberOfRows, int numberOfSeats) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        hall = new Seat[numberOfSeats + 1][numberOfRows + 1];
    }

    public void fillWithSeats() {
        fillWIthMarkerSeats();
        for (int i = 1; i < hall.length; i++) {
            for (int j = 1; j < hall[i].length; j++) {
                hall[i][j] = new Seat(i, j);
            }
        }
    }
    private void fillWIthMarkerSeats() {
        for (int i = 0; i <= numberOfRows; i++) {
            hall[0][i] = new Seat(0, i);
            hall[0][i].setAvailable(String.valueOf(i));
        }
        for (int i = 0; i <= numberOfSeats; i++) {
            hall[i][0] = new Seat(i, 0);
            hall[i][0].setAvailable(String.valueOf(i));
        }
        hall[0][0].setAvailable(" ");
    }

    public void printRows() {
        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                System.out.print(hall[j][i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public void getTotalIncome() {
        int totalIncome;
        if (numberOfRows * numberOfSeats <= 60) {
            totalIncome = numberOfRows * numberOfSeats * 10;
        } else {
            totalIncome = numberOfRows % 2 == 0 ? numberOfRows * numberOfSeats * 9
                    : (numberOfRows / 2 * numberOfSeats * 10) + ((numberOfRows / 2 + 1) * numberOfSeats * 8);
        }
        System.out.printf("Total income:\n$%d", totalIncome);
    }
}

