package com.asml.traversingmatrix;
//test
public enum Direction {
    LEFT_TO_RIGHT(0),
    RIGHT_TO_BOTTOM(1),
    RIGHT_TO_LEFT(2),
    BOTTOM_TO_TOP(3);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction getByValue(int value) {
        for (Direction d: values()) {
            if (d.value == value) {
                return d;
            }
        }
        return null;
    }
}
