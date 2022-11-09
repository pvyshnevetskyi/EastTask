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
       cinemaRoom.initialize();

       int userInput;
       while(true) {
           System.out.println("""
                   1. Show the seats
                   2. Buy a ticket
                   0. Exit
                   """);
        userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> cinemaRoom.printRows();
            case 2 -> cinemaRoom.buyTicket();
            case 0 -> {
                scanner.close();
                return;
            }
        }
       }
    }
}