/*
Flatten Binary Tree to Linked List Total Accepted: 21163 Total Submissions: 75128 My Submissions
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        preorder(tmp, root);
        TreeNode current = root;
        for (int i = 1; i < tmp.size(); i++) {
            current.left = null;
            current.right = new TreeNode(tmp.get(i));
            current = current.right;
        }
        return;
    }
    
    private void preorder(ArrayList<Integer> tmp, TreeNode root) {
        if (root == null) {
            return;
        }
        
        tmp.add(root.val);
        preorder(tmp, root.left);
        preorder(tmp, root.right);
    }
}