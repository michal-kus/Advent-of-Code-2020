import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static int getMaxValue(int[] values) {
        int maxValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }
    public static int getMissingId(int[] ids) {
        Arrays.sort(ids);
 
        for (int i = 1; i < ids.length; i++) {
            System.out.println(ids[i]);
            if (ids[i-1] + ids[i+1] != 2 * ids[i]){
                return ids[i + 1];
            }
        }
        return 0;

    }
    public static void main(String[] args) throws IOException {
        String[] input = AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt"));
        int[] ids = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            BoardingPass boardingPass = new BoardingPass(input[i]);
            ids[i] = boardingPass.getSeatId();
        }
        System.out.println(getMaxValue(ids));
        System.out.print(getMissingId(ids));
    }
}
