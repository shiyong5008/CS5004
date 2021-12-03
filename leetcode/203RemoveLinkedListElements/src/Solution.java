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
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        if (head.val == val) {
            head = head.next;
            return removeElements(head, val);
        }

        ListNode ptr = head.next;
        ListNode pre = head;

        while (ptr != null) {
            if (ptr.val == val) {
                pre.next = ptr.next;
                ptr = ptr.next;
            }else {
                ptr = ptr.next;
                pre = pre.next;
            }
        }

        return head;

    }
}
