package spiral_matrix_2;

import java.util.Arrays;

public class Solution {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowDir = 1;
        int colDir = 1;
        int i = 0;
        int j = -1;
        for (int k = n; k > 0; k--) {
            for (int l = 0; l < k; l++) {
                j += rowDir;
                matrix[i][j] = num;
                num++;
            }
            for (int l = 0; l < k - 1; l++) {
                i += colDir;
                matrix[i][j] = num;
                num++;
            }
            rowDir *= -1;
            colDir *= -1;
        }
        return matrix;
    }

    static void main() {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
}
