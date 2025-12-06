package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int width = matrix[0].length;
        int height = matrix.length - 1;
        int rowDir = 1;
        int colDir = 1;
        int i = 0;
        int j = -1;
        while (width > 0 && height > 0) {
            for (int k = 0; k < width; k++) {
                j += rowDir;
                result.add(matrix[i][j]);
            }
            for (int k = 0; k < height; k++) {
                i += colDir;
                result.add(matrix[i][j]);
            }
            rowDir *= -1;
            colDir *= -1;
            width--;
            height--;
        }
        for (int k = 0; k < width; k++) {
            j += rowDir;
            result.add(matrix[i][j]);
        }
        return result;
    }

    static void main() {
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{7,8,9}}
        ));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2,3,4},
            new int[]{5,6,7,8},
            new int[]{9,10,11,12}}
        ));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2},
            new int[]{5,6},
            new int[]{9,10}}
        ));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2,3},
            new int[]{5,6,4},
            new int[]{9,10,7},
            new int[]{12,11,13}
        }));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1},
            new int[]{5},
            new int[]{9},
            new int[]{12}
        }));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2,4,5},
        }));
        System.out.println(spiralOrder(new int[][]{
            new int[]{1,2,4,5,6,7},
            new int[]{1,2,4,5,6,7},
        }));
        System.out.println(spiralOrder(new int[][]{new int[]{1}}));
    }

}
