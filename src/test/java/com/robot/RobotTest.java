package com.robot;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Robot Movements.
 */
public class RobotTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testMovements() {
        String movements = "F1,R1,B2,L1,B3";
        int minDistanceExpected = 4;
        assertEquals(minDistanceExpected, RobotMain.calculateMovements(movements));
    }

    @Test
    public void testInvalidCommands() {
        String[] invalidCommands = {"", "F"}; // Empty string and single character input

        for (String command : invalidCommands) {
            assertFalse(RobotMain.isValidInput(command));
        }
    }

    @Test
    public void testInvalidFirstCharacter() {
        String[] invalidCommands = {"X1", "t3", "MoveForward5"};

        for (String command : invalidCommands) {
            assertFalse(RobotMain.isValidInput(command));
        }
    }

    @Test
    public void testInvalidSecondCharacter() {
        String[] invalidCommands = {"F!", "Rabc", "B#"};

        for (String command : invalidCommands) {
            assertFalse(RobotMain.isValidInput(command));
        }
    }
}
