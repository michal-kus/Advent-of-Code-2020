import java.util.HashSet;
import java.util.Set;

public class Group {

    public int getUniqueAnswersCount(String groupData) {
        Set<Character> uniqueAnsweredQuestions = new HashSet<Character>();
        groupData = groupData.replace(" ","").replace(AoCFileReader.lineSeparator, "");
        for (char c : groupData.toCharArray()) {
            uniqueAnsweredQuestions.add(c);
        }
        return uniqueAnsweredQuestions.size();
    }

    public int getFullyAnsweredQuestionsCount(String groupData) {
        int groupSize = AoCFileReader.splitStrIntoLines(groupData).length;
        Set<Character> uniqueAnsweredQuestions = new HashSet<Character>();
        groupData = groupData.replace(" ","").replace(AoCFileReader.lineSeparator, "");

        for (char c : groupData.toCharArray()) {
            uniqueAnsweredQuestions.add(c);
        }
        int count = 0;
        for (char c : uniqueAnsweredQuestions) {
            if (getCharOccurencesCount(groupData, c) == groupSize) {
                count++;
            }
        }
        return count;
    }
    private int getCharOccurencesCount(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}


