package combinations;

import java.util.*;

public class Solution {

    public static List<List<Integer>> combine(int n, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean popped = false;
        stack.push(1);
        while (!stack.isEmpty()) {
            if (popped) {
                stack.push(stack.pop() + 1);
            }
            int top = Optional.ofNullable(stack.peek()).orElse(n + 1);
            if (stack.size() == k) {
                while (top <= n) {
                    result.add(List.copyOf(stack));
                    top = stack.pop() + 1;
                    stack.push(top);
                }
                stack.pop();
                popped = true;
            } else if (n - top >= k - stack.size()) {
                stack.push(top + 1);
                popped = false;
            } else {
                stack.pop();
                popped = true;
            }
        }
        return result;
    }

    static void main() {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
        System.out.println(new HashSet<>(combine(20, 10)).size() == 184756);
    }

}
