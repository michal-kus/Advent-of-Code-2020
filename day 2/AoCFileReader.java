import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AoCFileReader {
    public static String getStrFromFile(String filename) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static String[] splitStrIntoLines(String data) {
        return data.split(System.getProperty("line.separator"));
    }
    public static int[] linesToArr(String[] lines) { //requires numbers only between new lines
        return new int[lines.length];
    }
}
