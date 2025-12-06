package rotate_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        List<Integer> values = new ArrayList<>();
        var node = head;
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        var start = new ListNode(-1);
        node = start;
        final int n = values.size();
        final int ks = n != 0 ? k % n : 0;
        for (int i = 0; i < n; i++) {
            node.val = values.get((n - ks + i) % n);
            var next = i < n - 1 ? new ListNode(-1) : null;
            node.next = next;
            node = next;
        }
        return start;
    }

}
