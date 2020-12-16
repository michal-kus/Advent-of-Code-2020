import java.io.IOException;
import java.util.Arrays;

public class Solution {
    static Memoizer memoizer = new Memoizer(1000);
    public static long countWaysToConnect(int index, int[] adapters) {
        if (memoizer.isCached(index)) {
            return memoizer.getCache(index);
        }
        long connectionsForThisAdapter = getConnectionPossibilitesCount(index, adapters);
        long waysToConnect = 0;
        if (connectionsForThisAdapter == 0) {
            waysToConnect = 1;
            return waysToConnect;
        }
        for (int i = 1; i <= connectionsForThisAdapter; i++) {
            waysToConnect += countWaysToConnect(index + i, adapters);
        }
        memoizer.putCache(index, waysToConnect);
        return memoizer.getCache(index);
        //return waysToConnect;
    }

    public static long getConnectionPossibilitesCount(int adapterIndex, int[] adapters) {
        int possibilitesCount = 0;
        for (int i = 1; i <= 3; i++) {            
            if (adapterIndex + i > adapters.length - 1) {
                continue;
            }
            int adaptersJoltsDifference = adapters[adapterIndex + i] - adapters[adapterIndex];
            if (adaptersJoltsDifference == 1) {
                possibilitesCount++;
            }
            if (adaptersJoltsDifference == 2) {
                possibilitesCount++;
            }
            if (adaptersJoltsDifference == 3) {
                possibilitesCount++;
            }
        }
        return possibilitesCount;
    }
    public static void main(String[] args) throws IOException {
        int[] adapters = AoCFileReader.strArrToIntArr(AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt")));
        Arrays.sort(adapters);
        System.out.println(countWaysToConnect(0, adapters) * 2); // Part 2
    }
}
