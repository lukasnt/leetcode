package remove_duplicates_from_sorted_array_2;

import java.util.Arrays;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int shift = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) count++;
            else {
                prev = nums[i];
                count = 1;
            }
            if (count > 2) shift++;
            else nums[i - shift] = nums[i];
        }
        return nums.length - shift;
    }

    static void printResult(int[] nums) {
        IO.println(removeDuplicates(nums));
        IO.println(Arrays.toString(nums));
    }

    static void main() {
        printResult(new int[]{1,1,1,2,2,3});
        printResult(new int[]{0,0,1,1,1,1,2,3,3});
        printResult(new int[]{0});
        printResult(new int[]{1,1,2,2,3,3,4,4,4,4,4});
    }

}
