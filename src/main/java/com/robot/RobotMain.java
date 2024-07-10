package com.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotMain {

    public static void main(String[] args) {
        String commandsString = args[0];
        List<Commands> commands = parseCommands(commandsString);

        Position position = new Position(0, 0, Direction.Directions.NORTH);

        int totalDistance = 0;
        for (Commands command : commands) {
            totalDistance += executeCommand(position, command);
        }

        // Calculate final distance based on robot's final position
        int finalDistance = position.getDistanceToStartPos();

        System.out.println("Minimum distance to return to starting point: " + finalDistance);
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
