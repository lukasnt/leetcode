package rotate_image;

import java.util.Arrays;

public class Solution {

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int last = matrix[matrix.length - j - 1][i];
                int temp = matrix[i][j];

                matrix[i][j] = last;
                last = temp;
                temp = matrix[j][matrix.length - i - 1];

                matrix[j][matrix.length - i - 1] = last;
                last = temp;
                temp = matrix[matrix.length - i - 1][matrix.length - j - 1];

                matrix[matrix.length - i - 1][matrix.length - j - 1] = last;
                last = temp;
                matrix[matrix.length - j - 1][i] = last;
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
    }

    static void main() {
        int[][] matrix1 = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9}
        };
        rotate(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = new int[][]{
            new int[]{5, 1, 9, 11},
            new int[]{2, 4, 8, 10},
            new int[]{13, 3, 6, 7},
            new int[]{15, 14, 12, 16}
        };
        rotate(matrix2);
        printMatrix(matrix2);

        int[][] matrix3 = new int[][]{
            new int[]{1, 2, 3, 4, 5},
            new int[]{6, 7, 8, 9, 10},
            new int[]{11, 12, 13, 14, 15},
            new int[]{16, 17, 18, 19, 20},
            new int[]{21, 22, 23, 24, 25}
        };
        rotate(matrix3);
        printMatrix(matrix3);
    }
}
