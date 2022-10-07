package com.asml.traversingmatrix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testGetByValue_whenValueInRange0to4_shouldReturnDirectionEnum() {

        assertAll("Should return the related Direction enum value",
                () -> assertEquals(Direction.LEFT_TO_RIGHT, Direction.getByValue(0)),
                () -> assertEquals(Direction.RIGHT_TO_BOTTOM, Direction.getByValue(1)),
                () -> assertEquals(Direction.RIGHT_TO_LEFT, Direction.getByValue(2)),
                () -> assertEquals(Direction.BOTTOM_TO_TOP, Direction.getByValue(3))
        );
    }

    @Test
    void testGetByValue_whenValueNotInRange0to4_shouldReturnNull() {
        assertNull(Direction.getByValue(5));
    }

}