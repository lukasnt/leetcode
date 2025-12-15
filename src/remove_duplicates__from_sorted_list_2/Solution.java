package remove_duplicates__from_sorted_list_2;

public class Solution {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode node(int val, ListNode next) {
        return new ListNode(val, next);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode include = null;
        var current = head;
        boolean remove = false;
        while (current != null) {
            boolean removeCurrent = false;
            var next = current.next;
            while (next != null && next.val == current.val) {
                next = next.next;
                removeCurrent = true;
            }
            if (removeCurrent) {
                remove = true;
            } else if (remove) {
                if (include == null) {
                    include = current;
                    head = include;
                } else {
                    include.next = current;
                    include = current;
                }
                remove = false;
            } else if (include == null) {
                include = current;
            } else {
                include.next = current;
                include = current;
            }
            current = next;
        }
        if (include == null) head = include;
        else if (remove) include.next = null;
        return head;
    }

    static void printList(ListNode head) {
        var current = head;
        while (current != null) {
            IO.println(current.val);
            current = current.next;
        }
        IO.println();
    }

    static void main() {
        printList(deleteDuplicates(node(1, node(2, node(3, node(3, node(4, node(4, node(5, null)))))))));
        printList(deleteDuplicates(node(1, node(1, node(1, node(2, node(3, null)))))));
        printList(deleteDuplicates(node(1, node(1, node(2, node(3, null))))));
        printList(deleteDuplicates(node(1, node(1, null))));
        printList(deleteDuplicates(node(0, node(1, node(1, node(2, node(2, null)))))));
        printList(deleteDuplicates(node(0, node(1, node(1, node(2, node(2, null)))))));
        printList(deleteDuplicates(node(1, node(1, node(2, node(2, node(5, null)))))));
        printList(deleteDuplicates(null));
    }
}
