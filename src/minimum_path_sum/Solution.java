package minimum_path_sum;

public class Solution {

    public static int minPathSum(int[][] grid) {
        int[][] paths = new int[grid.length][grid[0].length];
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                int from = Integer.MAX_VALUE;
                if (i > 0) from = Math.min(paths[i - 1][j], from);
                if (j > 0) from = Math.min(paths[i][j - 1], from);
                paths[i][j] = grid[i][j] + ((from != Integer.MAX_VALUE) ? from : 0);
            }
        }
        return paths[paths.length - 1][paths[0].length - 1];
    }

    static void main() {
        System.out.println(minPathSum(new int[][]{
            new int[]{1, 3, 1},
            new int[]{1, 5, 1},
            new int[]{4, 2, 1},
        }));
        System.out.println(minPathSum(new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
        }));
        System.out.println(minPathSum(new int[][]{
            new int[]{0, 0, 0},
            new int[]{4, 5, 0},
        }));
        System.out.println(minPathSum(new int[][]{
            new int[]{1, 1, 1},
        }));
        System.out.println(minPathSum(new int[][]{
            new int[]{1},
            new int[]{1},
            new int[]{1},
        }));
        System.out.println(minPathSum(new int[][]{
            new int[]{6},
        }));
    }

}
