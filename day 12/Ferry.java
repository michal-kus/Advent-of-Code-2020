public class Ferry {
    private String facingDirection = "E";
    private int x = 0;
    private int y = 0;
    private int waypointRelativeX = 10;
    private int waypointRelativeY = 1;

    public int getManhattanDistance() {
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        return x + y;
    }
    public void executeInstructions(String[] instructions) {
        for (int i = 0; i < instructions.length; i++) {
            executeInstruction(instructions[i]);
            System.out.print("x:");
            System.out.println(x);
            System.out.print("y:");
            System.out.println(y);
        }
    }
    private void executeInstruction(String instruction) {
        String function = instruction.substring(0,1);
        int argument = Integer.parseInt(instruction.substring(1));
        System.out.print(function);
        System.out.println(argument);
        String temp;
        switch(function) {
            case "N":                   //MOVE
                moveWaypoint(argument, "N");    
                break;
            case "S":
                moveWaypoint(argument, "S");    
                break;
            case "E":
                moveWaypoint(argument, "E");   
                break;
            case "W":
                moveWaypoint(argument, "W");
                break;
            case "F":
                moveToWaypoint(argument);    
                break;
            case "L":                   //ROTATE
                rotateWaypointCounterClockwise(argument);    
                break;
            case "R":
                rotateWaypointClockwise(argument);    
                break;
            default:
                System.out.println("Invalid Instruction");
        }
            
    }
    private void moveWaypoint(int distance, String direction) {
        switch(direction) {
            case "N":
                waypointRelativeY += distance;
                break;
            case "S":
                waypointRelativeY -= distance;
                break;
            case "E":
                waypointRelativeX += distance;
                break;
            case "W":
                waypointRelativeX -= distance;
                break;
            default:
                System.out.println("No such direction");
                break;
        }
    }
    private void rotateWaypointClockwise(int angle) {
        int rightAngles = angle/90;
        for (int i = 0; i < rightAngles; i++) {
            int newX = waypointRelativeY;
            int newY = -waypointRelativeX;
            waypointRelativeX = newX;
            waypointRelativeY = newY;
        }
    }
    private void rotateWaypointCounterClockwise(int angle) {
        int rightAngles = angle/90;
        for (int i = 0; i < rightAngles; i++) {
            int newX = -waypointRelativeY;
            int newY = waypointRelativeX;
            waypointRelativeX = newX;
            waypointRelativeY = newY;
        }
    }
    private void moveToWaypoint(int distance) {
        x += waypointRelativeX * distance;
        y += waypointRelativeY * distance;
        
    }
    private void rotateShipClockwise(int angle) {
        int rightAngles = angle/90;
        for (int i = 0; i < rightAngles; i++) {
            switch(facingDirection) {
                case "N":                   //MOVE
                    facingDirection = "E";
                    break;
                case "S":
                    facingDirection = "W";
                    break;
                case "E":
                    facingDirection = "S";
                    break;
                case "W":
                    facingDirection = "N";
                    break;
                default:
                    System.out.println("Invalid Instruction");
            }
        }  
    }
}