/*
Same Tree Total Accepted: 23822 Total Submissions: 56608 My Submissions
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            if (p.val == q.val) {
                return true;
            } else {
                return false;
            }
        } 
    
        return false;
    }
    
}