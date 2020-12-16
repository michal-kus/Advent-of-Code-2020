import java.io.IOException;

public class Solution {
    static String[] originalInstructions; 

    static void checkEveryScenario() {
        for (int i = 0; i < originalInstructions.length; i++) {     
            if (originalInstructions[i].split(" ")[0].equals("jmp")) {
                String[] newInstructions = new String[originalInstructions.length];
                for(int j = 0; j < originalInstructions.length; j++){
                    newInstructions[j] =originalInstructions[j];
                }
                newInstructions[i] = changeInstruction(newInstructions[i], "nop");
                ConsoleProgram consoleProgram = new ConsoleProgram(newInstructions);
                consoleProgram.executeInstruction(0);
            }
        }
    }
    static String changeInstruction(String oldInstruction, String function) {
        return function + " " + oldInstruction.split(" ")[1];
    }

    public static void main(String[] args) throws IOException {
        originalInstructions = AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt"));
        checkEveryScenario();
    }
}
