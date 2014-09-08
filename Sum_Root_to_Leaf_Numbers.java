/*
Sum Root to Leaf Numbers Total Accepted: 20566 Total Submissions: 69091 My Submissions
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> result = new ArrayList<Integer>();
        int tmp = 0;
        helper(result, tmp, root);
        
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i);
        }
        
        return sum;
    }
    
    private void helper(List<Integer> result, int tmp, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            tmp = tmp * 10 + root.val;
            result.add(tmp);
            return;
        }
        
        helper(result, tmp * 10 + root.val, root.left);
        helper(result, tmp * 10 + root.val, root.right);
    }
}