/*
Binary Tree Preorder Traversal Total Accepted: 27626 Total Submissions: 77757 My Submissions
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while(!s.isEmpty()) {
            TreeNode current = s.pop();
            result.add(current.val);
            if (current.right != null) {
                s.push(current.right);
            }
            if (current.left != null) {
                s.push(current.left);
            }
        }
        
        return result;
    }
}