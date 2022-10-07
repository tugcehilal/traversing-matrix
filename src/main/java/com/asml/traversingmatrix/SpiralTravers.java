package com.asml.traversingmatrix;

public class SpiralTravers {
    private static final int DIRECTION_COUNT = 4;
    private static final int NEXT_DIRECTION = 1;
    public synchronized void spiralTravers(int[][] arr) {
        //Time Complexity: O(M*N). To traverse the matrix O(M*M) time is required.
        //Auxiliary Space: O(1). No extra space is required.
        //T = TopLeft Corner, B = BottomRight Corner, L = LeftBottom Corner, R = RightTop Corner, dir = direction
        if (arr == null || arr.length == 0) {
            return;
        }
        int T = 0, B =  arr.length-1, L = 0, R = arr[0].length - 1, dir = 0;
        while (T <= B && L <= R) {
            if (Direction.getByValue(dir) == Direction.LEFT_TO_RIGHT) {
                for (int i = L; i <= R; i++) {
                    System.out.print(arr[T][i] + " ");
                }
                T++;
            } else if (Direction.getByValue(dir) == Direction.RIGHT_TO_BOTTOM) {
                for (int i = T; i <= B; i++) {
                    System.out.print(arr[i][R] + " ");
                }
                R--;
            } else if (Direction.getByValue(dir) == Direction.RIGHT_TO_LEFT) {
                for (int i = R; i >= L; i--){
                    System.out.print(arr[B][i] + " ");
                }
                B--;
            } else if (Direction.getByValue(dir) == Direction.BOTTOM_TO_TOP) {
                for (int i = B; i >= T; i--) {
                    System.out.print(arr[i][L] + " ");
                }
                L++;
            }
            dir = (dir + NEXT_DIRECTION) % DIRECTION_COUNT;
        }
    }
}
