/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        // if (head == null) return null;

        ListNode pre = null;
        ListNode ptr = head;

        while (ptr != null) {
            ListNode temp = ptr.next;

            ptr.next = pre;

            pre = ptr;
            ptr = temp;
        }
        return pre;

    }
}