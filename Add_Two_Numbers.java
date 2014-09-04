/*
Add Two Numbers Total Accepted: 21368 Total Submissions: 92673 My Submissions
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode left = l1;
        ListNode right = l2;
        
        int tmp = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmp;
            if (sum / 10 != 0) {
                tmp = 1;
            } else {
                tmp = 0;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int sum = l1.val + tmp;
            if (sum / 10 != 0) {
                tmp = 1;
            } else {
                tmp = 0;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + tmp;
            if (sum / 10 != 0) {
                tmp = 1;
            } else {
                tmp = 0;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            l2 = l2.next;
        }
        
        if (tmp != 0) { //Very Important!!!
          head.next = new ListNode(1);  
        }
        
        return dummy.next;
    }
}