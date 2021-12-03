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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] done = reverse(head, tail);
            head = done[0];
            tail = done[1];
            pre.next = head;
            tail.next = nex;

            head = nex;
            pre = tail;
        }

        return hair.next;
    }


    public ListNode[] reverse(ListNode head, ListNode tail) {

        ListNode ptr = head;

        ListNode pre = tail.next;
        while (pre != tail) {

            ListNode nex = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = nex;

        }
        return new ListNode[] {tail, head};
    }
}