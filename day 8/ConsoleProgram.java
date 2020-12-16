import java.util.HashSet;

public class ConsoleProgram {
    String[] instructions;
    int accumulator;
    HashSet<Integer> executedInstructions = new HashSet<>();

    public ConsoleProgram(String[] instructions) {
        this.instructions = instructions;
    }

    public void executeInstruction(int lineIndex) {
        if (isLooped(lineIndex)) {
            return;
        }
        if (lineIndex == instructions.length) {
            System.out.println("finished! acc value:");
            System.out.println(accumulator);
            return;
        }
        executedInstructions.add(lineIndex);
        String[] temp = instructions[lineIndex].split(" ");
        String function = temp[0];
        int argument = Integer.parseInt(temp[1]);
                
        switch(function) {
            case "acc":
                accumulator += argument;
                executeInstruction(lineIndex + 1);
                break;
            case "jmp":
                executeInstruction(lineIndex + argument);
                break;
            case "nop":
                executeInstruction(lineIndex + 1);
                break;
            default:
                System.out.println("No such instruction");
        }        
    }
    private boolean isLooped(int lineIndex) {
        return executedInstructions.contains(lineIndex);
    }   
}
