package com.asml.traversingmatrix;

public class TestSupport {

    public static int[][] square2DArray = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16},
    };
    public static String square2DArrayOutput = "1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 ";

    public static int[][] oneLevelArray = new int[][] {
            {1,2,3,4}
    };
    public static String oneLevelArrayOutput = "1 2 3 4 ";

    public static int[][] nonSquare2DArray = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
    };
    public static String nonSquare2DArrayOutput = "1 2 3 4 8 12 11 10 9 5 6 7 ";

}
