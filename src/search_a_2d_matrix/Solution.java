package search_a_2d_matrix;

public class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int low = 0;
        int high = m * n;
        int mid = (low + high) / 2;
        while (low != mid && high != mid) {
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            }
            if (val > target) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return target == matrix[mid / n][mid % n];
    }

    static void main() {
        System.out.println(searchMatrix(new int[][]{
            new int[]{1,3,5,7},
            new int[]{10,11,16,20},
            new int[]{23,30,34,6},
        }, 3));
        System.out.println(searchMatrix(new int[][]{
            new int[]{1,2,5,7},
            new int[]{10,11,16,20},
            new int[]{23,30,34,6},
        }, 3));
        System.out.println(searchMatrix(new int[][]{
            new int[]{1,3,5,7},
            new int[]{10,11,16,20},
            new int[]{23,30,34,6},
        }, 1));
        System.out.println(searchMatrix(new int[][]{
            new int[]{1}
        }, 1));
        System.out.println(searchMatrix(new int[][]{
            new int[]{1, 2}
        }, 1));
        System.out.println(searchMatrix(new int[][]{
            new int[]{0, 2}
        }, 1));
        System.out.println(searchMatrix(new int[][]{
            new int[]{0, 2}
        }, 2));
    }
}
