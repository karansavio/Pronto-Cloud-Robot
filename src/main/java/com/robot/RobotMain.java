package com.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotMain {

    public static void main(String[] args) {
        // Check if there's exactly one argument, if there is then display an error message
        if (args.length != 1) {
            System.err.println("Incorrect Input! Please enter a valid input");
            System.exit(1);
        }

        // Loops through the arguments to check if a valid input has been entered, else print an error message
        for (String arg : args) {
            if (!isValidInput(arg)) {
                System.err.println("Error! Invalid input value: " + arg);
                System.exit(1);
            }
        }

        String commandsString = args[0];

        // Calls the calculateMovements method to output the totalDistance as per the user input
        calculateMovements(commandsString);
    }

    public static int calculateMovements(String commandsString) {
        List<Commands> commands = parseCommands(commandsString); // Parsing commands string into a list of Command objects

        Position position = new Position(0, 0, Direction.Directions.NORTH); // Create a Position object representing the starting point (0, 0) and facing North

        int totalDistance = 0;
        for (Commands command : commands) {
            totalDistance += executeCommand(position, command); // Execute the current command on the robot's position and adds to the total distance
        }

        // Calculate final distance based on robot's final position
        totalDistance = position.getDistanceToStartPos();

        // Prints the total distance to return to the starting point
        System.out.println("Minimum distance to return to starting point: " + totalDistance);

        return totalDistance;
    }

    public static boolean isValidInput(String command) {
        // Invalid input length, it should contain 2 characters
        if (command.length() < 2) {
            return false; 
        }
    
        char firstChar = command.charAt(0);
        char secondChar = command.charAt(1);
    
        //Checking the first character should be F, R, B, or L
        if (! (firstChar == 'F' || firstChar == 'R' || firstChar == 'B' || firstChar == 'L')) {
            return false;
        }
    
        //Checking the second character should be a number
        if (!Character.isDigit(secondChar)) {
            return false;
        }
    
        return true;
    }

    public static List<Commands> parseCommands(String commandsString) {
        List<Commands> commands = new ArrayList<>();
        for (String commandStr : commandsString.split(",")) { // Split the commands string by comma
            char directionChar = commandStr.charAt(0); // Get the direction character (F, B, L, R)
            int distance = Integer.parseInt(commandStr.substring(1)); // Get the distance as an integer (ignoring the direction character)
            commands.add(new Commands(Direction.Directions.valueOf(String.valueOf(directionChar)), distance)); // Create a Command object and add it to the list
        }
        return commands;
    }

    public static int executeCommand(Position position, Commands command) {
        switch (command.getDirection()) {
            case F:
                position.moveAhead(command.getDistance());
                return command.getDistance();
            case B:
                position.moveBehind(command.getDistance());
                return command.getDistance();
            case L:
                position.dir = position.dir.turnLeft();
                return 0;
            case R:
                position.dir = position.dir.turnRight();
                return 0;
            default:
                break;
        }
        return 0;
    }
}
