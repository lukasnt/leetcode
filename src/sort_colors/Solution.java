package sort_colors;

import java.util.Arrays;

public class Solution {

    public static void sortColors(int[] nums) {
        int reds = 0;
        int whites = 0;
        int blues = 0;
        for (int color : nums) {
            if (color == 0) reds++;
            if (color == 1) whites++;
            if (color == 2) blues++;
        }
        int k = 0;
        while (k < nums.length) {
            if (reds > 0) {
                nums[k] = 0;
                reds--;
            } else if (whites > 0) {
                nums[k] = 1;
                whites--;
            } else if (blues > 0) {
                nums[k] = 2;
                blues--;
            }
            k++;
        }
    }

    static void printResult(int[] nums) {
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void main() {
        int[] n1 = new int[]{2,0,2,1,1,0};
        int[] n2 = new int[]{2,0,1};
        int[] n3 = new int[]{2};
        printResult(n1);
        printResult(n2);
        printResult(n3);
    }

}
