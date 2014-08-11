/*
Binary Tree Postorder Traversal Total Accepted: 25109 Total Submissions: 81165 My Submissions
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                if (current.right != null) {
                    s.push(current.right);
                }
                s.push(current);
                current = current.left;
            }
        
            if (s.isEmpty()) {
                return result;
            }
            
            current = s.pop();
            if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
                s.pop();
                s.push(current);
                current = current.right;
            }
            else {
                result.add(current.val);
                current = null;
            }
        }
    }
}