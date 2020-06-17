/*
  You are given two non-empty linked lists representing two non-negative integers.
  The digits are stored in reverse order and each of their nodes contain a single digit.
  Add the two numbers and return it as a linked list.

  You may assume the two numbers do not contain any leading zero, except the number 0 itself.

  Example:

  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 0 -> 8
  Explanation: 342 + 465 = 807.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode res = new ListNode();
        int c = 0;
        if (l1 == null && l2 == null) {
            if (carry > 0) {
                res.val = carry;
                return res;
            }
            return null;
        }
        if (l1 == null && l2 != null) {
            if (carry == 0) return l2;
            res.val = (l2.val + carry) % 10;
            c = (l2.val + carry) / 10;
            res.next = addTwoNumbers(null, l2.next, c);
        } else if (l2 == null && l1 != null) {
            if (carry == 0) return l1;
            res.val = (l1.val + carry) % 10;
            c = (l1.val + carry) / 10;
            res.next = addTwoNumbers(l1.next, null, c);
        } else {
            res.val = (l1.val + l2.val + carry) % 10;
            c = (l1.val + l2.val + carry) / 10;
            res.next = addTwoNumbers(l1.next, l2.next, c);
        }
        return res;
    }
        
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
}
