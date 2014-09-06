public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList result = new ArrayList();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new Queue<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (itn i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if ( head.left != null) {
					queue.offer(head.left);
				}

				if (head.right != null) {
					queue.offer(head.right);
				}
			}

			result.add(level);
		}

		return result;
	}
}


public class Solution {
	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		traverse(root.left);

		traverse(root.right);
	}
}


public class Solution {
	public ResultType traversal(TreeNode root) {
		if (root == null)  {

			// do something
		}

		//Divide
		ResultType left = traversal(root.left);
		ResultType right = traversal(root.right);

		//Conquer

		ResultType result = Merge from left to right;

		return result;
	}
}

public class Solution {
	public ArrayList<Integer> preOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while(!s.isEmpty()) {
			TreeNode current = s.pop();
			if (current.right != null) {
				s.push(current.right);
			} 
			if (current.left != null) {
				s.push(current.left);
			}

			result.add(current.val);

		}
		return result;
	}
}