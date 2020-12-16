import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] input = AoCFileReader.getBatches(AoCFileReader.getStrFromFile("input.txt"));
        int result = 0;
        for (String groupAnswers : input) {
            System.out.println("dupal");
            Group group = new Group();
            result += group.getFullyAnsweredQuestionsCount(groupAnswers);
        }
        System.out.print(result);
    }
}
