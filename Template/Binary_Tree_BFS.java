public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList result = new ArrayList();

		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Array<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if(head.left != null) {
					queue.offer(head.left);
				}
				if(head.right != null) {
					queue.offer(head.right);
				}
			}

			result.add(level); 
			//Notice: level Order Bottom
			/*
			result.add(0, line);
			*/
		}
	}
}

//zigzag
public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	if(root == null) {
		return result;
	}

	Stack<TreeNode> s = new Stack<TreeNode>();
	boolean order = true;
	while(!s.isEmpty()) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Stack<TreeNode> next = new Stack<TreeNode>();

		while(!s.pop()) {
			TreeNode current = s.pop();
			tmp.add(current.val);
			if(order) {
				if(current.left != null) {
					next.push(current.left);
				}
				if(current.right != null) {
					next.push(current.right);
				}
			} else {
				if (current.right != null) {
					next.push(current.right);
				}
				if (current.left != null) {
					next.push(current.left);
				}
			}

			order = !order;
			s = next;
			rst.add(tmp);

		}

		return rst;
	}
}

