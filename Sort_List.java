/*
Sort List Total Accepted: 19885 Total Submissions: 97148 My Submissions
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null; //Very Important
        ListNode left = sortList(head);
        
        ListNode newHead = merge(left, right);
        
        return newHead;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
            
        }
        
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        
        return dummy.next;
    }
 }