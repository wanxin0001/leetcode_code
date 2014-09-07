/*
Swap Nodes in Pairs Total Accepted: 20749 Total Submissions: 63952 My Submissions
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode first = head;
        ListNode second = head.next;
        
        while (first != null && second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;
            prev.next = second;
            prev = first;
            first = tmp;
            
            if (tmp == null || tmp.next == null) {
                return dummy.next;
            } else {
                second = tmp.next;
            }
            
        }
        return dummy.next;
    }
}