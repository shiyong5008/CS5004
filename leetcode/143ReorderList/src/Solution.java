import java.util.ArrayList;

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
    public void reorderList(ListNode head) {

        /* fail
        if (head.next == null) return;

        ListNode ptr = head;
        ListNode tail = head;

        while (tail.next.next != null) {
            tail = tail.next;
        }
        ListNode n = tail.next;
        n.next = ptr.next;
        ptr.next = n;
        tail.next = null;
        ptr = n.next;
        reorderList(ptr.next);

         */

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;

        while(node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            --j;
        }
        list.get(i).next = null;

    }
}
