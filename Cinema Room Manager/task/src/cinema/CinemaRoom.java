package cinema;

import java.util.Scanner;

public class CinemaRoom {

    private int numberOfRows;
    private int numberOfSeats;
    public Seat[][] movieHall;
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
    public void getTotalIncome() {
        int totalIncome;
        if (numberOfRows * numberOfSeats <= 60) {
            totalIncome = numberOfRows * numberOfSeats * 10;
        } else {
            totalIncome = numberOfRows % 2 == 0 ? numberOfRows * numberOfSeats * 9
                    : (numberOfRows / 2 * numberOfSeats * 10) + ((numberOfRows / 2 + 1) * numberOfSeats * 8);
        }
        System.out.printf("Total income:\n$%d\n", totalIncome);
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
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        System.out.printf("Ticket price: $%d\n", movieHall[seatNumber][rowNumber].getPrice());
        movieHall[seatNumber][rowNumber].setAvailable("B");
        printRows();
    }
}

