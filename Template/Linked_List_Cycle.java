/*
Linked List Cycle Total Accepted: 25597 Total Submissions: 71572 My Submissions
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        
        return false;
    }
}