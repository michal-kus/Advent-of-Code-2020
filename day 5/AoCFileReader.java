import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AoCFileReader {
    private static String lineSeparator = System.getProperty("line.separator");

    private AoCFileReader() {
        throw new IllegalStateException("Utility class");
    }
    public static String getStrFromFile(String filename) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static String[] splitStrIntoLines(String data) {
        return data.split(lineSeparator);
    }
    public static int[] linesToArr(String[] lines) { //requires numbers only between new lines
        return new int[lines.length];
    }
    public static String[] getBatches(String input) {
        return input.split(lineSeparator + lineSeparator);
    }
    public static String[] splitBySpacesAndLineSeparators (String str) {
        return str.split("( )|(" + lineSeparator + ")");
    } 
}
