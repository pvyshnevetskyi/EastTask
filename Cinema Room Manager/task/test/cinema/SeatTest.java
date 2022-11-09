package cinema;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeatTest {
    private Seat seat;
    @Before
    public void createSample() {
        seat = new Seat(1, 1);
        seat.setPrice(10);
    }

    @Test
    public void testToString() {
        assertEquals("incorrect toString result", "S", seat.toString());
    }

    @Test
    public void setAvailable() {
        seat.setAvailable("B");
        assertEquals("B", seat.getAvailable());
    }

    @Test
    public void getAvailable() {
        assertEquals("S", seat.getAvailable());
    }

    @Test
    public void getPrice() {
        assertEquals(10, seat.getPrice());
    }

    @Test
    public void setPrice() {
        seat.setPrice(5);
        assertEquals(5, seat.getPrice());
    }
}