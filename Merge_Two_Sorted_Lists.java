/*
Merge Two Sorted Lists Total Accepted: 23131 Total Submissions: 69488 My Submissions
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode left = l1;
        ListNode right = l2;
        
        while(left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                head = head.next;
                left = left.next;
            } else {
                head.next = right;
                head = head.next;
                right = right.next;
            }
        }
        
        if (left != null) {
            head.next = left;
        }
        
        if (right != null) {
            head.next = right;
        }
        
        return dummy.next;
    }
}