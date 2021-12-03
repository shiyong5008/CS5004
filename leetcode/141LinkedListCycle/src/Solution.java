import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/*
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
      }
  }

public class Solution {
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode ptr = head;
        while (ptr.next != null) {
            if (!set.add(ptr)) return true;
            ptr = ptr.next;
        }
        return false;

    }
}

 */



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
