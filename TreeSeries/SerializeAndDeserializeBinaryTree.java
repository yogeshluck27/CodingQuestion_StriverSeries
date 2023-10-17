package TreeSeries;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	// 					10
	//			 11 					14

	// 	null		 null 		22 				29

	public String serialize(TreeNode root) {
		// We are doing level order Traversal.
		// Instead of checking null condition , we will be considering null &
		// adding # to result
		// We will not check left & right of null Node
		// res = 10 11 14 # # 22 29
		if (root == null)
			return "";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder res = new StringBuilder();

		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			if (node == null) {
				res.append("# ");
				continue;
			}
			res.append(node.val + " ");
			queue.add(node.left);
			queue.add(node.right);

		}

		return res.toString();

	}
	// data = 10 11 14 # # 22 29

	// Output Tree :
	// 					10
	//			 11 					14

	// 	null		 null 		22 				29

	public TreeNode deSerialize(String data) {

		if (data == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String[] values = data.split(" ");

		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		queue.add(root);
		//queue = //10 
		for (int i = 1; i < values.length; i++) {
			//queue = //10 //11 14 //14
			
			TreeNode parent = queue.poll(); //queue = //  //14  // 
			 //Every time Poll the first node from queue
			
			if (!values[i].equals("#")) {
				TreeNode left = new TreeNode(Integer.parseInt(values[i]));
				parent.left = left;
				queue.add(left);  //queue = //11 
			}
			if (!values[++i].equals("#")) {
				TreeNode right = new TreeNode(Integer.parseInt(values[i]));
				parent.right = right;
				queue.add(right); //queue = //11 14
			}

		}

		return root;
	}
}
