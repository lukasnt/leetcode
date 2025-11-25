package permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(List.of(nums[0])));
            return result;
        } else if (nums.length == 0) {
            return Collections.emptyList();
        }

        int[] current = new int[nums.length - 1];
        System.arraycopy(nums, 1, current, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> perm : permute(current)) {
            perm.add(nums[0]);
            result.add(perm);
        }
        for (int i = 0; i < current.length; i++) {
            int temp = current[i];
            current[i] = nums[i];
            for (List<Integer> perm : permute(current)) {
                perm.add(temp);
                result.add(perm);
            }
        }
        return result;
    }

    static void main() {
        System.out.println(permute(new int[] {1, 2 ,3}));
        System.out.println(permute(new int[] {1, 2}));
        System.out.println(permute(new int[] {1}));
        System.out.println(permute(new int[] {}));
    }

}
