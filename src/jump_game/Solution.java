package jump_game;

public class Solution {

    public static boolean canJump(int[] nums) {
        int min = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= min) {
                min = i;
            }
        }
        return min == 0;
    }

    static void main() {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0,2,1,0,4}));
        System.out.println(canJump(new int[]{1,1,1,0,4}));
        System.out.println(canJump(new int[]{2,0,2,0,4}));
        System.out.println(canJump(new int[]{2,3,0,0,4}));
    }
}
