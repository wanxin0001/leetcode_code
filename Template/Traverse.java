public class Solution {
	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		//do something with root
		traverse(root.left);
		//do something with root
		traverse(root.right);
		//do something with root
	}
}