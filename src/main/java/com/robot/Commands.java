package com.robot;

// This class sets up the movement direction to the user input commands and the final distance to origin.
public class Commands {
    private Direction.Directions direction;
    private int distance;

    public Commands(Direction.Directions direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public Direction.Directions getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }
    
}
