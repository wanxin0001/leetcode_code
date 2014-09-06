/*
Binary Tree Level Order Traversal II Total Accepted: 17074 Total Submissions: 54596 My Submissions
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//It's the LinkedList
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                tmp.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(0, new ArrayList<Integer>(tmp));
        }
        
        return result;
    }
}