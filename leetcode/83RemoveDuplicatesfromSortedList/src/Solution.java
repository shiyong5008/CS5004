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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;



/*
        class Solution(object):
        def deleteDuplicates(self, head):
        if not head or not head.next:
        return head
        if head.val != head.next.val:
        head.next = self.deleteDuplicates(head.next)
        else:
        move = head.next
        while move.next and head.val == move.next.val:
        move = move.next
        return self.deleteDuplicates(move)
        return head

        作者：fuxuemingzhu
        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/fu-xue-ming-zhu-di-gui-die-dai-4-chong-d-t3bp/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

    }
}
