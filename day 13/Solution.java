import java.io.IOException;

public class Solution {
    public static long getValidTime(int[] buses) {
        int maxBusId = 0;
        int maxBusIdIndex = 0;
        for (int i = 0; i < buses.length; i++) {
            if (buses[i] > maxBusId) {
                maxBusId = buses[i];
                maxBusIdIndex = i;
            }
        }
        int step = maxBusId;
        buses[maxBusIdIndex] = 1;

        for(long time = maxBusId - maxBusIdIndex; time < Long.MAX_VALUE; time += step) {
             if (isTimeValid(time, buses)) {
                 return time;
             }
        }
        return 0;
    }
    public static boolean isTimeValid(long time, int[] buses) {
        for (int i = 0; i < buses.length; i++) {
            if (!isBusDeparting(time + i, buses[i])) {
                break;
            }
            if (i == buses.length - 1) {
                return true;
            }
        }
        return false; 
    }
    public static boolean isBusDeparting(long time, int bus) {
        if (bus == 1) { return true; }
        return (time % bus == 0);
    }
    public static void main(String[] args) throws IOException {
        String input = AoCFileReader.getStrFromFile("input.txt");
        input = input.replace("x", "1");
        int[] buses = AoCFileReader.strArrToIntArr(input.split(AoCFileReader.LINESEPARATOR)[1].split(","));
        long startTime = System.nanoTime();
        System.out.println(getValidTime(buses));
        long endTime = System.nanoTime();
        System.out.print("time:");
        System.out.println((endTime - startTime));
    }
}
