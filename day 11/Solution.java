import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void copySeatLayout(char[][] oldLayout, char[][] newLayout) {
        for (int i = 0; i < oldLayout.length; i++) {
            System.arraycopy(oldLayout[i], 0, newLayout[i], 0, oldLayout[i].length);
        }
    }
    public static char[][] updateArray(char[][] seatLayout) {
        char[][] newSeatLayout = new char[seatLayout.length][seatLayout[0].length];
        for (int i = 0; i < seatLayout.length; i++) {
            for (int j = 0; j < seatLayout[0].length; j++) {
                Seat seat = new Seat(i, j);
                newSeatLayout[i][j] = seat.updateSeatStatus(seatLayout);
            }
        }
        return newSeatLayout;
    }
    public static int countOccupiedSeats(char[][] seatLayout) {
        int count = 0;
        for (char[] row : seatLayout) {
            for (char seat : row) {
                if (seat == '#') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        char[][] seatLayout = AoCFileReader.toTwoDimensionalCharArray(AoCFileReader.getStrFromFile("input.txt"));

        for (int i = 0; i < 1000; i++) {
            if (!Arrays.deepEquals(seatLayout, updateArray(seatLayout))) {
                seatLayout = updateArray(seatLayout);
            }
            else {
                System.out.println(countOccupiedSeats(seatLayout));
                break;
            }
        }
    }
}