/*
Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… You must do this in-place without altering the nodes' values. For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode second = reverse(mid.next);
        mid.next = null;
        merge(head, second);
        
        return;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
    
    private void merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (first != null && second != null) {
            cur.next = first;
            first = first.next;//Notice the order
            cur = cur.next;//Notice the order
            
            cur.next = second;
            cur = cur.next;
            second = second.next;
        }
        if (first != null) {
            cur.next = first;
        } else {
            cur.next = second;
        }
        return;
    }
}