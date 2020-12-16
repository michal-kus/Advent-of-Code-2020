import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] instructions = AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt"));
        Ferry ferry = new Ferry();
        ferry.executeInstructions(instructions);
        System.out.println(ferry.getManhattanDistance());
    }
}
