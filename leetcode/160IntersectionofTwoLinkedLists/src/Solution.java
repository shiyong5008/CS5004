import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /*
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode a = headA;
        ListNode b = headB;

        while (a != null || b != null) {
            if (a != null) {
                if (set.add(a)) a = a.next;
                else return a;
            }
            if (b != null) {
                if (set.add(b)) b = b.next;
                else return b;
            }
        }
        return null;
         */

        ListNode a = headA;
        ListNode b = headB;

        if (a == null && b == null) return null;

        while (a != b) {
            if (a != null) a = a.next;
            else a = headB;

            if (b != null) b = b.next;
            else b = headA;
        }

        return a;
    }
}
