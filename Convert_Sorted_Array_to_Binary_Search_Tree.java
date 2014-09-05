/*
Convert Sorted Array to Binary Search Tree Total Accepted: 19570 Total Submissions: 60019 My Submissions
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


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
    
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        
        
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(num[(start + end) / 2]);
        TreeNode left = sortedArrayToBSTHelper(num, start, (start + end) / 2 - 1);
        TreeNode right = sortedArrayToBSTHelper(num, (start + end) / 2 + 1, end);
        root.left = left;
        root.right = right;
        
        return root;
    }
}