import java.util.List;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = new ListNode(l2.val, temp);
            l2 = l2.next;
        }

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        while (true) {

            if (ptr1.val > ptr2.val) {
                ListNode temp = ptr1;
                ptr1 = new ListNode(ptr2.val, temp);
                ptr1 = ptr1.next;

                if (ptr2.next == null) {
                    return l1;
                } else {
                    ptr2 = ptr2.next;
                }

            } else {
                if (ptr1.next == null) {
                    ptr1.next = ptr2;
                    return l1;
                } else {
                    ptr1 = ptr1.next;
                }
            }
        }

         */


        /*
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode preHead = new ListNode(-99);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pre = preHead;

        while (true) {

            if (p1.val < p2.val) {
                pre.next = p1;
                pre = pre.next;
                if (p1.next == null) {
                    pre.next = p2;
                    return preHead.next;
                } else {
                    p1 = p1.next;
                }
            }
            if (p2.val <= p1.val) {
                pre.next = p2;
                pre = pre.next;
                if (p2.next == null) {
                    pre.next = p1;
                    return preHead.next;
                } else {
                    p2 = p2.next;
                }
            }
        }

         */


        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
