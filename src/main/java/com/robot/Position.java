package com.robot;

// This class implements the logic on the movement position and distance to starting position
public class Position {
    private int x, y;
    Direction.Directions dir;

    public Position(int x, int y, Direction.Directions dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void moveAhead(int distance) {
        switch (dir) {
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

    public void moveBehind(int distance) {
        moveAhead(-distance);
    }

    public int getDistanceToStartPos() {
        return Math.abs(x) + Math.abs(y);
    }
}

