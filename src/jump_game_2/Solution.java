package jump_game_2;

public class Solution {

    public static int jump(int[] nums) {
        int[] solutions = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (solutions[j] == 0) {
                    solutions[j] = solutions[i] + 1;
                }
                if (j == nums.length - 1) {
                    return solutions[j];
                }
            }
        }
        return solutions[nums.length - 1];
    }

    static void main() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
        System.out.println(jump(new int[]{1,2,1,1,1}));
    }

}
