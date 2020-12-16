  import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AoCFileReader {
    public static final String LINESEPARATOR = System.getProperty("line.separator");

    private AoCFileReader() {
        throw new IllegalStateException("Utility class");
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
