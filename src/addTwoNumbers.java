import java.util.List;

public class addTwoNumbers {

    public static void main (String args[]) {

        ListNode q = new ListNode(3, null);
        ListNode c = new ListNode(4, q);
        ListNode l = new ListNode(2, c);

        ListNode b = new ListNode(3, null);
        ListNode t = new ListNode(4, b);
        ListNode r = new ListNode(2, t);

        addTwoNumbers(l, r);

    }


    /*
    Attempt 1: https://leetcode.com/problems/add-two-numbers/

    My solution was almost exactly best case.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // if l1.next = 0 for head, then return l2 reversed. vice versa.

        ListNode head = new ListNode(0);
        ListNode curr = head;

        int carry = 0;

       while ( carry != 0 || l1 != null || l2 != null) {
           int l1Val;
           int l2Val;

           if (l1 != null) l1Val = l1.val;
           else l1Val = 0;
           if (l2 != null) l2Val = l2.val;
           else l2Val = 0;

           int sum = l1Val + l2Val + carry;
           carry = sum / 10;

           curr.next = new ListNode(sum % 10);
           curr = curr.next;

           if (l1 != null) l1 = l1.next;
           if (l2 != null) l2 = l2.next;
       }

       return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
