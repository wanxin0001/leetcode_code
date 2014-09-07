/*
Recover Binary Search Tree Total Accepted: 14897 Total Submissions: 63291 My Submissions
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        preorder(root, result);
        int tmp = result.get(0).val;
        result.get(0).val = result.get(1).val;
        result.get(1).val = tmp;
        return;
    }
    private TreeNode lastNode = null;
    private void preorder(TreeNode root, ArrayList<TreeNode> result) {
        if (root == null) {
            return;
        }
        
        preorder(root.left, result);
        if (result.size() == 0) {
            if (lastNode == null) {
                lastNode = root;
            } else {
                if (lastNode.val > root.val) {
                    result.add(lastNode);
                    result.add(root);
                }
                lastNode = root;
            } 
        }else {
        
            if (lastNode.val > root.val) {
                result.set(1, root);
                return;
            }
            lastNode = root;
        }
        
        preorder(root.right, result);
        
        return;
    }
}