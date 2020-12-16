import java.io.IOException;

public class Solution {

    private static int getTreeEncounterCount(String[] lines, int xTranslation, int yTranslation) {
        int treeEncounterCount = 0;
        int x = 0;
        int forestWidth = lines[0].length();
        int forestLength = lines.length;

        for (int y = 0; y < forestLength; y += yTranslation) {
            if (x >= forestWidth)  {
                x = x - forestWidth;
            }
            if (lines[y].charAt(x) == '#') {
                treeEncounterCount++;
            }
            x += xTranslation;
        }
        return treeEncounterCount;
    }
    
    public static void main(String[] args) throws IOException {
        String[] lines = AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt"));
        long result = getTreeEncounterCount(lines, 1, 1) * 
        getTreeEncounterCount(lines, 3, 1) *
        getTreeEncounterCount(lines, 5, 1) *
        getTreeEncounterCount(lines, 7, 1) *
        getTreeEncounterCount(lines, 1, 2);
        System.out.println(result);
    }
}