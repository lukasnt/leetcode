package search_insert_position;

class Solution {

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r + 1) / 2;
        while (m != l && m != r) {
            int num = nums[m];
            if (target < num) {
                r = m;
            } else if (target > num) {
                l = m;
            } else {
                return m;
            }

            m = (l + r + 1) / 2;
        }
        if (target <= nums[l]) return l;
        if (target > nums[r]) return r + 1;
        return m;
    }

    static void main() {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0));
        System.out.println(searchInsert(new int[] {1}, 0));
        System.out.println(searchInsert(new int[] {1,3}, 1));
    }
}
