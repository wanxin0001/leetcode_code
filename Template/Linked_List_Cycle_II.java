/*
Linked List Cycle II Total Accepted: 18643 Total Submissions: 60390 My Submissions
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            slow = head;
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
        
    }
}