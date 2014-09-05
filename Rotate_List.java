/*
Rotate List Total Accepted: 15587 Total Submissions: 70610 My Submissions
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = findLength(head);
        int pos = n % size;
        if (pos == 0) {
            return head;
        }
        
        ListNode leftHead = head;
        ListNode left = head;
        ListNode right = head;
        while (pos > 0) {
            right = right.next;
            pos--;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        ListNode rightHead = left.next;
        left.next = null;
        right.next = leftHead;
        
        return rightHead;
        
    }
    
    private int findLength(ListNode head) {
        ListNode head1 = head;
        int size = 0;
        while (head1 != null) {
            size++;
            head1 = head1.next;
        }
        return size;
    }
}