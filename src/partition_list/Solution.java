package partition_list;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode node(int val, ListNode next) { return new ListNode(val, next); }

    static void printList(ListNode head) {
        IO.println();
        var current = head;
        while (current != null) {
            IO.println(current.val);
            current = current.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        var prevSplit = new ListNode();
        var current = head;
        ListNode split = null;
        while (split == null && current != null) {
            if (current.val >= x) {
                split = current;
            } else {
                prevSplit = current;
                current = current.next;
            }
        }
        if (split != null) {
            var prev = split;
            var less = prevSplit;
            while (current != null) {
                if (current.val < x) {
                    if (prev != null) {
                        prev.next = current.next;
                        prev = null;
                    }
                    if (less.next == null) head = current;
                    less.next = current;
                    less = current;
                    less.next = split;
                } else {
                    prev = current;
                }
                current = current.next;
            }
        }
        return head;
    }

    static void main() {
        printList(
            partition(node(1, node(4, node(3, node(2, node(5, node(2, null)))))),
            3)
        );
        printList(
            partition(node(1, node(4, node(3, node(2, node(5, node(2, null)))))),
            4)
        );
        printList(
            partition(node(1, node(4, node(3, node(2, node(1, node(2, null)))))),
            3)
        );
        printList(partition(node(2, node(1, null)),
            2)
        );
        printList(partition(node(1, node(1, null)),
            2)
        );
        printList(partition(node(1, null),
            1)
        );
        printList(partition(node(1, null),
            2)
        );
        printList(partition(null, 1));
    }

}
