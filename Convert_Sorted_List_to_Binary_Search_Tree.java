/*
Convert Sorted List to Binary Search Tree Total Accepted: 18037 Total Submissions: 66112 My Submissions
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode current = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        int size = findSize(head);
        
        current = head;
        
        return subBST(size);
    }
    
    private int findSize(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
    
    private TreeNode subBST(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = subBST(size/2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = subBST(size - 1 - size/2);
        
        root.left = left;
        root.right = right;
        return root;
    }
}