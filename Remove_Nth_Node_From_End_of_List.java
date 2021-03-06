/*
Remove Nth Node From End of List Total Accepted: 20072 Total Submissions: 67180 My Submissions
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //For this problem, we need dummy node, the reason is that we may delete the first node
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        
        left.next = left.next.next;
        return dummy.next;
    }
}