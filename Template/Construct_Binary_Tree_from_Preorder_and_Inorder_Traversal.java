/*
Construct Binary Tree from Preorder and Inorder Traversal Total Accepted: 14591 Total Submissions: 55118 My Submissions
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        
        TreeNode result = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return result;
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode current = new TreeNode(preorder[preStart]);
        int pos = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                pos = i;
            }
        }
        TreeNode left = helper(preorder, 1 + preStart, pos - inStart + preStart , inorder, inStart, pos - 1);
        TreeNode right = helper(preorder, preStart + pos - inStart + 1, preEnd, inorder, pos + 1, inEnd);
        
        current.left = left;
        current.right = right;
        return current;
    }
}