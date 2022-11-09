package cinema;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CinemaRoomTest {
    private CinemaRoom cinemaRoom;
    private CinemaRoom smallCinema;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        smallCinema = new CinemaRoom(3, 3);
        cinemaRoom = new CinemaRoom(8, 8);
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void initialize() {
        cinemaRoom.initialize();
        assertNotNull("No seats in cinemaRoom", cinemaRoom.getSeats()[4][4]);
    }

    @Test
    public void fillWithSeats() {
        cinemaRoom.fillWithSeats();
        assertNotNull("No seats in cinemaRoom", cinemaRoom.getSeats()[5][5]);
        assertNotNull("No seats in cinemaRoom", cinemaRoom.getSeats()[8][8]);
        assertNotNull("No seats in cinemaRoom", cinemaRoom.getSeats()[1][1]);
    }

    @Test
    public void printRows() {
        cinemaRoom.initialize();
        cinemaRoom.printRows();

        assertEquals("Cinema:\n" +
                "  1 2 3 4 5 6 7 8 \n" +
                "1 S S S S S S S S \n" +
                "2 S S S S S S S S \n" +
                "3 S S S S S S S S \n" +
                "4 S S S S S S S S \n" +
                "5 S S S S S S S S \n" +
                "6 S S S S S S S S \n" +
                "7 S S S S S S S S \n" +
                "8 S S S S S S S S \n", outputStreamCaptor.toString());
    }

    @Test
    public void getTotalIncome() {
        CinemaRoom oddRowsCinema = new CinemaRoom(9, 9);
        smallCinema.initialize();
        assertEquals(90, smallCinema.getTotalIncome());
        assertEquals(576, cinemaRoom.getTotalIncome());
        assertEquals(720, oddRowsCinema.getTotalIncome());
    }

    @Test
    public void numOfPurchasedTickets() {
    }

    @Test
    public void assignPricesToSeats() {
        smallCinema.fillWithSeats();
        smallCinema.assignPricesToSeats();
        cinemaRoom.fillWithSeats();
        cinemaRoom.assignPricesToSeats();
        assertEquals(10, cinemaRoom.getSeats()[5][2].getPrice());
        assertEquals(8, cinemaRoom.getSeats()[6][7].getPrice());
        assertEquals(10, smallCinema.getSeats()[3][3].getPrice());
    }

    @Test
    public void buyTicket() {
        cinemaRoom.initialize();
        InputStream backup = System.in;
        String inputOne = "2";
        String inputTwo = "2";
        InputStream in = new ByteArrayInputStream(inputOne.getBytes());
        System.setIn(in);
        assertEquals("B", cinemaRoom.getSeats()[2][2].getAvailable());
    }

    @Test
    public void statistics() {
        cinemaRoom.initialize();
        cinemaRoom.statistics();

        assertEquals("Number of purchased tickets: 0\n" +
                "Percentage 0.00%\n" +
                "Current income: $0\n" +
                "Total income: $576", outputStreamCaptor.toString().trim());
    }
    @Test
    public void validateInputForPurchase() {
        cinemaRoom.initialize();
        cinemaRoom.getSeats()[2][2].setAvailable("B");
        assertFalse(cinemaRoom.validateInputForPurchase(0, 1));
        assertFalse(cinemaRoom.validateInputForPurchase(9, 1));
        assertFalse(cinemaRoom.validateInputForPurchase(2, 2));
        assertTrue(cinemaRoom.validateInputForPurchase(5, 5));
    }
}