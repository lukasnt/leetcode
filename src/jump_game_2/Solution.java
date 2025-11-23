package jump_game_2;

import java.util.Arrays;

public class Solution {

    public static int jump(int[] nums) {
        int[][] solutions = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int optimal = Integer.MAX_VALUE;
            for (int k = i - 1; k >= 0; k--) {
                if (solutions[k][i] <= optimal && solutions[k][i] != 0) {
                    optimal = solutions[k][i];
                }
            }
            if (i == 0) {
                optimal = 0;
            }
            solutions[i][i] = optimal;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                solutions[i][j] = optimal + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(solutions[i]));
        }
        return solutions[nums.length - 1][nums.length - 1];
    }

    static void main() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));

    }

}
