package maximum_subarray;

public class Solution {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = 0;
        boolean neg = true;
        int negMax = nums[0];
        for (int num : nums) {
            if (current + num > 0) {
                current += num;
            } else {
                current = 0;
            }
            if (current > max) {
                max = current;
            }
            if (num > 0) {
                neg = false;
            } else {
                negMax = Math.max(num, negMax);
            }
        }
        if (neg) {
            return negMax;
        } else {
            return max;
        }
    }

    static void main() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-5,-4,-1,-7,-8}));
        System.out.println(maxSubArray(new int[]{-5,4,-1,-7,8}));
    }

}
