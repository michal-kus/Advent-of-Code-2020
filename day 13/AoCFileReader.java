import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AoCFileReader {
    public static final String LINESEPARATOR = System.getProperty("line.separator");

    private AoCFileReader() {
        throw new IllegalStateException("Utility class");
    }
    public static char[][] toTwoDimensionalCharArray(String input) {
        String[] lines = AoCFileReader.splitStrIntoLines(input);
        char[][] twoDimensionalCharArray = new char[lines[1].length()][lines.length];
        for (int i = 0; i < lines.length; i++) {        //i = y
            char[] row = lines[i].toCharArray();
            for (int j = 0; j < lines[0].length(); j++) {    //j = x
                twoDimensionalCharArray[j][i] = row[j];
            }
        }
        return twoDimensionalCharArray;
    }
    public static String getStrFromFile(String filename) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static String[] splitStrIntoLines(String data) {
        return data.split(LINESEPARATOR);
    }
    public static int[] strArrToIntArr(String[] str) {
        int[] arr = new int[str.length];
        for(int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
    public static String[] getBatches(String input) {
        return input.split(LINESEPARATOR + LINESEPARATOR);
    }
    public static String[] splitBySpacesAndLineSeparators (String str) {
        return str.split("( )|(" + LINESEPARATOR + ")");
    } 
    public static void printArray(int[] arr) {
        System.out.print("["); 
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+","); 
        }
        System.out.println("]"); 
    }
}
