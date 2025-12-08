package set_matrix_zeroes;

import java.util.Arrays;

public class Solution {

    public static void setZeroes(int[][] matrix) {
        boolean fillCurrent = false;
        boolean fillNext = false;
        for (int k = 0; k < matrix[0].length; k++) {
            if (matrix[0][k] == 0) {
                fillCurrent = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];
                int next = i < matrix.length - 1 ? matrix[i + 1][j] : 1;
                if (next == 0) fillNext = true;
                if (val == 0){
                    if (i < matrix.length - 1) {
                        matrix[i + 1][j] = 0;
                    }
                    for (int l = i - 1; l >= 0; l--) {
                        matrix[l][j] = 0;
                    }
                }
            }
            if (fillCurrent) {
                Arrays.fill(matrix[i], 0);
            }

            fillCurrent = fillNext;
            fillNext = false;
        }
    }

    static void printResult(int[][] matrix) {
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static void main() {
        int[][] m1 = new int[][] {
            new int[]{1, 1, 1},
            new int[]{1, 0, 1},
            new int[]{1, 1, 1},
        };
        int[][] m2 = new int[][] {
            new int[]{0, 1, 2, 0},
            new int[]{3, 4, 5, 2},
            new int[]{1, 3, 1, 5},
        };
        int[][] m3 = new int[][] {
            new int[]{0, 1, 2, 0}
        };
        int[][] m4 = new int[][] {
            new int[]{0},
            new int[]{1},
            new int[]{1}
        };
        int[][] m5 = new int[][] {
            new int[]{5}
        };
        printResult(m1);
        printResult(m2);
        printResult(m3);
        printResult(m4);
        printResult(m5);
    }

}
