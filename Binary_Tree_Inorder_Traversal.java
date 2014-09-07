/*
Binary Tree Inorder Traversal Total Accepted: 25490 Total Submissions: 71815 My Submissions
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(true) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            
            if(s.isEmpty()) {
                return result;
            }
            
            current = s.pop();
            result.add(current.val);
            current = current.right;
        }
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}