/*
Insertion Sort List Total Accepted: 20520 Total Submissions: 81207 My Submissions
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(head != null) {
            ListNode tmp = head.next;
            tail = dummy;
            while (tail.next != null && tail.next.val < head.val) {
                tail = tail.next;
            }
            if (tail.next != null) {
                ListNode right = tail.next;// not tail.next.next
                tail.next = head;
                head.next = right;
            } else {
                tail.next = head;
                head.next = null;
            }
            
            
            
            head = tmp;
        }
        
        return dummy.next;
    }
}