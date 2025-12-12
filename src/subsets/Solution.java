package subsets;

import java.util.*;

public class Solution {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        Arrays.sort(nums);
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) queue.add(List.of(i));
        while (!queue.isEmpty()) {
            var current = queue.poll();
            result.add(current.stream().map(i -> nums[i]).toList());
            int index = current.getLast();
            for (int i = index + 1; i < nums.length; i++) {
                List<Integer> next = new ArrayList<>(current);
                next.add(i);
                queue.add(next);
            }
        }
        return result;
    }

    static void main() {
        IO.println(subsets(new int[]{1, 2, 3}));
        IO.println(subsets(new int[]{2, 3, 1}));
        IO.println(subsets(new int[]{100, 3, 50}));
        IO.println(subsets(new int[]{1, 2, 3, 4}));
        IO.println(subsets(new int[]{0}));
    }

}
