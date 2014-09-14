/*
Reverse Nodes in k-Group Total Accepted: 14322 Total Submissions: 57547 My Submissions
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        
        int size = findLength(head);
        if (size < k) {
            return head;
        }
        ListNode current = dummy;
        ListNode cur = head;
        for (int i = 0; i < size / k ; i++) {
            ArrayList<ListNode> result = reverseK(cur, k);
            current.next = result.get(1);
            current = result.get(0);
            cur = result.get(2);
        }
        if (size % k != 0) {
            
            current.next = cur;
        }
        return dummy.next;
    }
    private ArrayList<ListNode> reverseK(ListNode head, int k) {
        ArrayList<ListNode> result = new ArrayList<ListNode>();
        ListNode prev = null;
        result.add(head);
        while (head != null && k > 0) {
            
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                k--;
        }
        result.add(prev);
        result.add(head);
        return result;
        
    }
    private int findLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
}