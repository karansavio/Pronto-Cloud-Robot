package com.robot;

// The implementation of the turns and rotations of the robot arm
public class Direction {
    enum Directions {
        NORTH,
        EAST,
        SOUTH,
        WEST, 
        F, 
        B, 
        L, 
        R;
    
        // Method to turn left from the current direction
        public Directions turnLeft() {
            return values()[(ordinal() - 1 + values().length) % values().length];
        }
    
        // Method to turn right from the current direction
        public Directions turnRight() {
            return values()[(ordinal() + 1) % values().length];
        }
    }
}

