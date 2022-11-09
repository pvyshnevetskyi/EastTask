package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

       CinemaRoom cinemaRoom = new CinemaRoom(numberOfRows, numberOfSeats);

       cinemaRoom.fillWithSeats();
       cinemaRoom.printRows();
       cinemaRoom.getTotalIncome();

       scanner.close();
    }
}