package simplify_path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 1;
        while (i < path.length() && i != 0) {
            int slashIndex = path.indexOf("/", i);
            String sub = path.substring(i, slashIndex != -1 ? slashIndex : path.length());
            if (sub.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!sub.equals(".") && !sub.isEmpty()) {
                stack.push(sub);
            }
            i = slashIndex + 1;
        }

        return "/" + stack.reversed().stream()
            .reduce((a, b) -> a + "/" + b)
            .orElse("");
    }

    static void main() {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/../a/../b/c/../d/./"));
    }

}
