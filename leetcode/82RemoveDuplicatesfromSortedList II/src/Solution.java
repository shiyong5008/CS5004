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
    public ListNode deleteDuplicates(ListNode head) {

/* fail
        ListNode pre = new ListNode();
        ListNode newH = new ListNode();
        ListNode ptr = head;

        if (ptr == null || ptr.next == null) return ptr;
        if (ptr.val != ptr.next.val) {
            pre = head;
            newH = pre;
            ptr = ptr.next;
        } else {
            while (ptr.next != null) {
                if (ptr.val == ptr.next.val) {
                    ptr = ptr.next;
                } else if (ptr.next.next != null && ptr.next.val == ptr.next.next.val) {
                    ptr = ptr.next;
                } else {
                    break;
                }
            }
            pre = ptr.next;
            newH = pre;
            ptr = ptr.next.next;
        }

        while (ptr != null) {
            if (ptr.next != null && ptr.val != ptr.next.val) {
                pre = ptr;
                ptr = ptr.next;
            } else {
                while (ptr != null) {
                    if (ptr.next != null && ptr.val == ptr.next.val) {
                        ptr = ptr.next;
                    } else if (ptr.next.next != null && ptr.next.val == ptr.next.next.val) {
                        ptr = ptr.next;
                    } else {
                        break;
                    }
                }
                if (ptr != null) {
                    pre.next = ptr.next;
                    ptr = ptr.next.next;
                }
            }
        }
        return newH;

 */

        ListNode cur = new ListNode();
        cur.next = head;
        ListNode dummy = cur;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
