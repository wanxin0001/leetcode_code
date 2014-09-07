/*
Populating Next Right Pointers in Each Node II Total Accepted: 16900 Total Submissions: 55555 My Submissions
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        root.next = null;
        
        while( !queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode lastNode = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode current = queue.poll();
                if (lastNode == null) {
                    lastNode = current;
                } else {
                    lastNode.next = current;
                    lastNode = lastNode.next;
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            lastNode.next = null;
        }
        return;
    }
    
    
}