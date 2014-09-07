/*
Construct Binary Tree from Inorder and Postorder Traversal Total Accepted: 14152 Total Submissions: 53544 My Submissions
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length ==0) {
            return null;
        }
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode current = new TreeNode(postorder[postEnd]);
        int pos = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == current.val) {
                pos = i;
            }
        }
        
        TreeNode left = helper(inorder, inStart, pos - 1, postorder, postStart, postStart - 1 + pos - inStart);
        TreeNode right = helper(inorder, pos + 1, inEnd, postorder, postStart + pos - inStart, postEnd - 1);
        
        current.left = left;
        current.right = right;
        return current;
    }
}