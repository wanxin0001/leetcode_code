/*
Binary Tree Zigzag Level Order Traversal Total Accepted: 14972 Total Submissions: 56128 My Submissions
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean flag = true;
        while(!stack.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int size = stack.size();
            Stack<TreeNode> stackCur = new Stack<TreeNode>();
            for (int i = 0; i < size; i++) {
                TreeNode current = stack.pop();
                
                tmp.add(current.val);
                if (flag) {
                    if (current.left != null) {
                        stackCur.push(current.left);
                    } 
                    if (current.right != null) {
                        stackCur.push(current.right);
                    }
                } else {
                    if (current.right != null) {
                        stackCur.push(current.right);
                    }
                    if (current.left != null) {
                        stackCur.push(current.left);
                    }
                }
            
            }
            stack = stackCur;
            flag = !flag;        
            result.add(new ArrayList<Integer>(tmp));
        }
        return result;
    }
}