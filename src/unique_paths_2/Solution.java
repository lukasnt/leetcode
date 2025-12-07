package unique_paths_2;

public class Solution {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        paths[0][0] = 1;
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                int sum = 0;
                if (i > 0 && obstacleGrid[i - 1][j] != 1) sum += paths[i - 1][j];
                if (j > 0 && obstacleGrid[i][j - 1] != 1) sum += paths[i][j - 1];
                paths[i][j] = obstacleGrid[i][j] != 1 ? Math.max(sum, paths[i][j]) : 0;
            }
        }
        return paths[paths.length - 1][paths[0].length - 1];
    }

    static void main() {
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0, 0, 0},
            new int[]{0, 1, 0},
            new int[]{0, 0, 0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0, 1},
            new int[]{0, 0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0, 0, 1},
            new int[]{0, 1, 0},
            new int[]{1, 0, 0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0, 0, 1},
            new int[]{0, 1, 0},
            new int[]{0, 0, 0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0, 0, 0},
            new int[]{0, 0, 0},
            new int[]{0, 0, 0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{0},
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
            new int[]{1},
        }));
    }
}
