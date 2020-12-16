import java.io.IOException;

class Solution {
    private int[] getCharCountBoundaries (String line) { 
        StringBuilder lowerBoundStr = new StringBuilder();
        StringBuilder upperBoundStr = new StringBuilder();


        int i = 0;
        while (Character.isDigit(line.charAt(i))) {
            lowerBoundStr.append(line.charAt(i));
            i++;
        }
        i++; //ignore hyphen 
        while (Character.isDigit(line.charAt(i))) {
             upperBoundStr.append(line.charAt(i));
             i++;
        }
        int[] result = new int[2];
        result[0] = Integer.parseInt(lowerBoundStr.toString());
        result[1] = Integer.parseInt(upperBoundStr.toString());
        return result;
        
    }
    private char getValidatingChar (String line) {
        int i = 0;
        while (!Character.isLetter(line.charAt(i))) {
            i++;
        }
        return line.charAt(i);
    }
    public int getValidPasswordCount(String[] lines) {
        int correctPasswordsCount = 0;
        for(int i = 0; i < lines.length; i++) {
            int[] bounds = getCharCountBoundaries(lines[i]);
            int lowerBound = bounds[0];
            int upperBound = bounds[1];
            char validatingChar = getValidatingChar(lines[i]);
            int validatingLettersCount = lines[i].length() - lines[i].replace(String.valueOf(validatingChar), "").length() - 1;
            if (validatingLettersCount >= lowerBound && validatingLettersCount <= upperBound) {
                correctPasswordsCount++;
            }
        }
        return correctPasswordsCount;
    }
    public int getNewValidPasswordCount(String[] lines) {

        int correctPasswordsCount = 0;
        for(int i = 0; i < lines.length; i++) {

            int[] positions = getCharCountBoundaries(lines[i]); //should be named getCharPositions in this context
            int firstPos = positions[0];
            int secondPos = positions[1];

            char validatingChar = getValidatingChar(lines[i]);
            
            int j = 0;
            while (lines[i].charAt(j) != ':') {//ignore everything before colon
                j++;
            }
            j++;//ignore colon and a space, then take elven indexing from 1 into account

            if (lines[i].charAt(j + firstPos) == validatingChar ^ lines[i].charAt(j + secondPos) == validatingChar) {
                correctPasswordsCount++;
            }
        }
        return correctPasswordsCount;
    }

    public static void main(String[] args) throws IOException {
            Solution solution = new Solution();
            String input = AoCFileReader.getStrFromFile("input.txt");
            String[] lines = AoCFileReader.splitStrIntoLines(input);
            System.out.print(solution.getValidPasswordCount(lines));
            System.out.print(solution.getNewValidPasswordCount(lines));
        }
    }

