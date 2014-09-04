/*
Reverse Linked List II Total Accepted: 17231 Total Submissions: 66308 My Submissions
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mPrev = dummy;
        ListNode mPtr = head;
        ListNode nPost = head.next;
        ListNode nPtr = head;
        
        while (n > 1) {
            if (m > 1) {
                mPrev = mPrev.next;
                mPtr = mPtr.next;
                m--;
            }
            nPost = nPost.next;
            nPtr = nPtr.next;
            n--;
        }
        
        mPrev.next = null;
        nPtr.next = null;
        
        ListNode prev = null;
        head = mPtr;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        mPrev.next = prev;
        mPtr.next = nPost;
        
        return dummy.next;
    }
}