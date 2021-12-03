
/*
import java.util.List;

public class AddTwoNumbers {
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
/*
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbersHelp(l1, l2, 0);
        }

        public static ListNode addTwoNumbersHelp(ListNode l1, ListNode l2, int a) {
            if (l1 == null && l2 == null) {
                return a == 0 ? null : new ListNode(a);
            }
            if (l1 != null) {
                a += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                a += l2.val;
                l2 = l2.next;
            }
            return new ListNode(a % 10, addTwoNumbersHelp(l1, l2, a / 10));
        }

        public static String toString(ListNode l) {
            String res="";
            while(l!=null) {
                if(l.next!=null) {
                    res=res+l.val+",";
                }else {
                    res=res+l.val;
                }
                l=l.next;
            }
            return "["+res+"]";
        }

        public static void main(String[] args) {
            ListNode a1=new ListNode(3, null);
            ListNode b1=new ListNode(4, a1);
            ListNode l1=new ListNode(2, b1);

            ListNode a2=new ListNode(4, null);
            ListNode b2=new ListNode(6, a2);
            ListNode l2=new ListNode(5, b2);

            ListNode l3=addTwoNumbers(l1,l2);
            System.out.println(toString(l3));

        }
    }



}
*/


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
/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbersHelp(l1, l2, 0);
    }

    public ListNode addTwoNumbersHelp(ListNode l1, ListNode l2, int n) {
        if (l1 == null && l2 != null) {
            if (n == 0) {
                return l2;
            } else {
                return new ListNode((n+l2.val)%10, addTwoNumbersHelp(null, l2.next, (n+l2.val)/10));
            }
        } else if (l2 == null && l1 != null) {
            if (n == 0) {
                return l1;
            } else {
                return new ListNode((n+l1.val)%10, addTwoNumbersHelp(l1.next, null, (n+l1.val)/10));
            }
        } else if (l1 == null && l2 == null) {
            if (n == 0) {
                return null;
            }else {
                return new ListNode(n, null);
            }
        } else {
            int sum = (l1.val + l2.val + n) % 10;
            int add = (l1.val + l2.val + n) / 10;
            return new ListNode(sum, addTwoNumbersHelp(l1.next, l2.next, add));
        }
    }
}

 */


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;
        int x;
        int y;
        int carry = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                x = 0;
            } else {
                x = l1.val;
            }
            if (l2 == null) {
                y = 0;
            } else {
                y = l2.val;
            }

            if (head == null) {
                head = tail = new ListNode((x+y)%10);
                carry = (x+y)/10;
            } else {
                tail.next = new ListNode((x+y+carry)%10);
                carry = (x+y+carry)/10;
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}