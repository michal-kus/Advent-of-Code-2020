import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        int preambleLength = 25;
        long[] inputArray = AoCFileReader.strArrToLongArr(AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt")));
        Validator validator = new Validator();

        // Part 1
        System.out.println(validator.validateArray(inputArray, preambleLength));
        
        // Part2
        validator.getEncryptionWeakness(inputArray, 105950735);
    }
}
