package com.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotMain {

    public static void main(String[] args) {

        String commandsString = args[0];
        List<Command> commands = parseCommands(commandsString);

        Position position = new Position(0, 0, Direction.NORTH);
        // Direction direction = Direction.NORTH;

        int totalDistance = 0;
        for (Command command : commands) {
            totalDistance += executeCommand(position, command);
        }

        // Calculate final distance based on robot's final position
        int finalDistance = position.getDistanceToOrigin();

        System.out.println("Minimum distance to return to starting point: " + finalDistance);
    }

    private static List<Command> parseCommands(String commandsString) {
        List<Command> commands = new ArrayList<>();
        for (String commandStr : commandsString.split(",")) {
            char directionChar = commandStr.charAt(0);
            int distance = Integer.parseInt(commandStr.substring(1));
            commands.add(new Command(Direction.valueOf(String.valueOf(directionChar)), distance));
        }
        return commands;
    }

    private static int executeCommand(Position position, Command command) {
        switch (command.getDirection()) {
            case F:
                position.moveForward(command.getDistance());
                return command.getDistance();
            case B:
                position.moveBackward(command.getDistance());
                return command.getDistance();
            case L:
                // direction = direction.turnLeft();
                position.direction = position.direction.turnLeft();
                return 0;
            case R:
                // direction = direction.turnRight();
                position.direction = position.direction.turnRight();
                return 0;
            default:
                break;
        }
        return 0;
    }
}

enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST, F, B, L, R;

    public Direction turnLeft() {
        return values()[(ordinal() - 1 + values().length) % values().length];
    }

    public Direction turnRight() {
        return values()[(ordinal() + 1) % values().length];
    }
}

class Position {
    private int x;
    private int y;
    Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveForward(int distance) {
            switch (direction) {            
            case NORTH:
                y += distance;
                break;
            case SOUTH:
                y -= distance;
                break;
            case EAST:
                x += distance;
                break;
            case WEST:
                x -= distance;
                break;                
            default:
                break;
        }
    }

    public void moveBackward(int distance) {
        moveForward(-distance);
    }

    public int getDistanceToOrigin() {
        return Math.abs(x) + Math.abs(y);
    }
}

class Command {
    private final Direction direction;
    private final int distance;

    public Command(Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }
}
