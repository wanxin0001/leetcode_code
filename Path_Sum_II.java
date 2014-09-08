/*
Path Sum II Total Accepted: 19205 Total Submissions: 71040 My Submissions
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        helper(result, tmp, root, sum);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> tmp, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            tmp.add(root.val);
            result.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        } 
        
        
        tmp.add(root.val);
        
        helper(result, tmp, root.left, sum - root.val);
        
        
        helper(result, tmp, root.right, sum - root.val);
        
        tmp.remove(tmp.size() - 1);
    }
}