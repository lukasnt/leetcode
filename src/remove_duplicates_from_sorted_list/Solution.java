package remove_duplicates_from_sorted_list;

public class Solution {

     // Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode node(int val, ListNode next) {
        return new ListNode(val, next);
    }

    static void printNode(ListNode node) {
         var current = node;
         while (current != null) {
             IO.println(current.val);
             current = current.next;
         }
    }

    public static ListNode deleteDuplicates(ListNode head) {
         if (head == null) return null;
         var prev = head;
         var current = head.next;
         while (current != null) {
             while (current != null && prev.val == current.val) {
                 current = current.next;
             }
             prev.next = current;
             prev = current;
             current = current != null ? current.next : null;
         }
         return head;
    }

    static void main() {
         printNode(deleteDuplicates(node(1, node(1, node(2, null)))));
         printNode(deleteDuplicates(node(1, node(1, node(2, node(3, node(3, null)))))));
    }

}
