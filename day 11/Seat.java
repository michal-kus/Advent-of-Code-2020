
public class Seat {
    private static final char EMPTY = 'L';
    private static final char OCCUPIED = '#';
    private static final char FLOOR = '.';

    int x;
    int y;

    public Seat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public char updateSeatStatus(char[][] seatLayout) {
        switch(seatLayout[x][y]) {
            case EMPTY:
                if (countVisibleOccupiedSeats(seatLayout) == 0) {
                    return OCCUPIED;
                }
                return EMPTY;
            case OCCUPIED:
                if (countVisibleOccupiedSeats(seatLayout) >= 5) {
                    return EMPTY;
                }
                return OCCUPIED;
            case FLOOR:
                return FLOOR;
            default:
                return '?';
        }
    }

    private int countAdjacentOccupiedSeats(char[][] seatLayout) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isSeatOccupied(x + i, y + j, seatLayout)) { 
                    count++;
                }
            }
        }
        if (isSeatOccupied(x, y, seatLayout)) {
            count--;
        }
        return count;
    }
    private int countVisibleOccupiedSeats(char[][] seatLayout) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int distance = 1; distance < 200; distance++) {
                    if (isSeatOccupied(x + i * distance, y + j * distance, seatLayout)) { 
                        count++;
                        break;
                    }
                    else if (!areIndicesValid(x + i * distance, y + j * distance, seatLayout)) {
                        break;
                    }
                    if (seatLayout[x + i * distance][y + j * distance] == EMPTY) {
                        break;
                    }
                }
            }
        }
        if (isSeatOccupied(x, y, seatLayout)) {
            count--;
        }
        return count;
    }
    private boolean isSeatOccupied(int x, int y, char[][] seatLayout) {
        if (!areIndicesValid(x, y, seatLayout)) {
            return false;
        }
        return (seatLayout[x][y] == OCCUPIED);
    }
    private boolean areIndicesValid(int x, int y, char[][] seatLayout) {
        if (x < 0 || x >= seatLayout.length) {
            return false;
        }
        if (y < 0 || y >= seatLayout[0].length) {
            return false;
        }
        return true;
    }
}
