package cinema;

public class Theatre {

    private int height;
    private int width;
    private Seat[][] rows;
    public Theatre (int height, int width) {
        this.height = height;
        this.width = width;
        rows = new Seat[width + 1][height + 1];
    }

    public void fillWithSeats() {
        //adding row numbering
        for (int i = 0; i <= height; i++) {
            rows[0][i] = new Seat(0, i);
            rows[0][i].setAvailable(String.valueOf(i));
        }
        for (int i = 0; i <= width; i++) {
            rows[i][0] = new Seat(i, 0);
            rows[i][0].setAvailable(String.valueOf(i));
        }
        rows[0][0].setAvailable(" ");


        for (int i = 1; i < rows.length; i++) {
            for (int j = 1; j < rows[i].length; j++) {
                rows[i][j] = new Seat(i, j);
            }
        }

    }

    public void printRows() {
        System.out.println("Cinema:");
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                System.out.print(rows[j][i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}

