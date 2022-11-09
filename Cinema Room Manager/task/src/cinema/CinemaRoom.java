package cinema;

import javax.swing.text.html.ImageView;
import java.util.Scanner;

public class CinemaRoom {

    private final int numberOfRows;
    private final int numberOfSeats;
    private final Seat[][] movieHall;
    private int currentIncome = 0;
    private int numOfPurchasedTickets = 0;

    public CinemaRoom(int numberOfRows, int numberOfSeats) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        movieHall = new Seat[numberOfSeats + 1][numberOfRows + 1];
    }

    public void initialize() {
        fillWithSeats();
        assignPricesToSeats();
    }

    public void fillWithSeats() {
        fillWIthMarkerSeats();
        for (int i = 1; i < movieHall.length; i++) {
            for (int j = 1; j < movieHall[i].length; j++) {
                movieHall[i][j] = new Seat(i, j);
            }
        }
    }

    private void fillWIthMarkerSeats() {
        for (int i = 0; i <= numberOfRows; i++) {
            movieHall[0][i] = new Seat(0, i);
            movieHall[0][i].setAvailable(String.valueOf(i));
        }
        for (int i = 0; i <= numberOfSeats; i++) {
            movieHall[i][0] = new Seat(i, 0);
            movieHall[i][0].setAvailable(String.valueOf(i));
        }
        movieHall[0][0].setAvailable(" ");
    }

    public void printRows() {
        System.out.println("Cinema:");
        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                System.out.print(movieHall[j][i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public int getTotalIncome() {
        int totalIncome;
        if (numberOfRows * numberOfSeats <= 60) {
            totalIncome = numberOfRows * numberOfSeats * 10;
        } else {
            totalIncome = numberOfRows % 2 == 0 ? numberOfRows * numberOfSeats * 9
                    : (numberOfRows / 2 * numberOfSeats * 10) + ((numberOfRows / 2 + 1) * numberOfSeats * 8);
        }
        return totalIncome;
    }
    public double numOfPurchasedTickets() {
        return ((numOfPurchasedTickets * 1.0) / ((numberOfSeats) * (numberOfRows))) * 100;
    }

    public void assignPricesToSeats() {
        if (numberOfRows * numberOfSeats <= 60) {
            for (int i = 1; i <= numberOfRows; i++) {
                for (int j = 1; j <= numberOfSeats; j++) {
                    movieHall[j][i].setPrice(10);
                }
            }
        } else {
            for (int i = 1; i <= numberOfRows / 2; i++) {
                for (int j = 1; j <= numberOfSeats; j++) {
                    movieHall[j][i].setPrice(10);
                }
            }
            for (int i = numberOfRows / 2 + 1; i <= numberOfRows; i++) {
                for (int j = 1; j <= numberOfSeats; j++) {
                    movieHall[j][i].setPrice(8);
                }
            }
        }
    }

    public void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row number:");
            int rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNumber = scanner.nextInt();

            if (!validateInputForPurchase(rowNumber, seatNumber)) continue;

            System.out.printf("Ticket price: $%d\n", movieHall[seatNumber][rowNumber].getPrice());
            currentIncome += movieHall[seatNumber][rowNumber].getPrice();
            numOfPurchasedTickets++;
            movieHall[seatNumber][rowNumber].setAvailable("B");
            printRows();
            return;
        }
    }

    public boolean validateInputForPurchase(int rowNumber, int seatNumber) {
        if (rowNumber < 1 || seatNumber < 1 || rowNumber > numberOfRows || seatNumber > numberOfSeats) {
            System.out.println("Wrong input");
            return false;
        }
        if (movieHall[seatNumber][rowNumber].getAvailable().equals("B")) {
            System.out.println("That ticket has already been purchased!");
            return false;
        }
        return true;
    }

    public void statistics() {
        System.out.printf("Number of purchased tickets: %d\n",numOfPurchasedTickets);
        System.out.printf("Percentage %.2f%%\n",numOfPurchasedTickets());
        System.out.printf("Current income: $%d\n",currentIncome);
        System.out.printf("Total income: $%d\n", getTotalIncome());
    }
    public Seat[][] getSeats() {
        return movieHall;
    }
}

