package find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

class Solution {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            } else {
                return new int[] {-1, -1};
            }
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (nums[mid] != target && nums[mid + 1] != target) {
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
            if (mid != (low + high) / 2) {
                mid = (low + high) / 2;
            } else {
                return new int[] {-1, -1};
            }
        }

        while (nums[low] != target) low++;
        while (nums[high] != target) high--;

        return new int[]{low, high};
    }

    public static void printResult(int[] nums, int target) {
        System.out.println("--------------------");
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("target: " + target);
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static void main(String[] args) {
        printResult(new int[] {5,7,7,8,8,10}, 8);
        printResult(new int[] {5,7,7,8,8,10}, 6);
        printResult(new int[] {}, 0);
        printResult(new int[] {5,7,7,8,8,8,8,8,8,10}, 8);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,10}, 7);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,10}, 1);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,9,10}, 9);
        printResult(new int[] {0}, 0);
        printResult(new int[] {0,0}, 0);
        printResult(new int[] {0,0,0}, 0);
        printResult(new int[] {0,0,0,1}, 1);
        printResult(new int[] {0,0,0,1,1}, 1);
        printResult(new int[] {0,1,1,1,1}, 0);
    }
}