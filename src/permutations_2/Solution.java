package permutations_2;

import java.util.*;

public class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(List.of(nums[0])));
            return result;
        } else if (nums.length == 0) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> inverted = new HashMap<>();
        int first = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != first) inverted.putIfAbsent(nums[i], i);
        }
        int[] current = new int[nums.length - 1];
        System.arraycopy(nums, 1, current, 0, nums.length - 1);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> perm : permuteUnique(current)) {
            perm.add(first);
            result.add(perm);
        }
        int prevValue = first;
        for (var entry : inverted.entrySet()) {
            current[entry.getValue() - 1] = prevValue;
            for (List<Integer> perm : permuteUnique(current)) {
                perm.add(entry.getKey());
                result.add(perm);
            }
            prevValue = entry.getKey();
        }

        return result;
    }

    static void main() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{2, 1, 2}));
        System.out.println(permuteUnique(new int[]{2, 2, 2}));
        System.out.println(permuteUnique(new int[]{2}));
        System.out.println(permuteUnique(new int[]{}));
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
        System.out.println(permuteUnique(new int[]{1, 2, 3, 4}).stream().distinct().toList());
    }


}
