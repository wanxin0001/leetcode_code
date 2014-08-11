/*
Balanced Binary Tree Total Accepted: 20344 Total Submissions: 62435 My Submissions
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


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
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
        
    }
}

/* Method by myself.
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left - right) > 1) {
            return false;
        }
        else{
            if(!isBalanced(root.left)) {
                return false;
            }
            else if(!isBalanced(root.right)) {
                return false;
            }
            return true;
        }
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
        
    }
}
*/