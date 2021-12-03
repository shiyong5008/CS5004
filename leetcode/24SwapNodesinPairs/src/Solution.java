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
class Solution {
    public ListNode swapPairs(ListNode head) {

        /* fail
        if (head == null || head.next == null) return head;

        ListNode cur = new ListNode();
        ListNode dummy = cur;
        ListNode temp = head;
        cur.next = head.next;
        cur = cur.next;

        while (temp != null && cur != null) {
            temp.next = cur.next;
            cur.next = temp;

            temp = temp.next;
            if (cur.next != null && cur.next.next != null) {
                cur = cur.next.next.next;
            }
        }
        return dummy.next;

         */


        /* recursive
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode();
        newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;

        return newHead;

         */


        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;

            cur.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            // cur = n1;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
