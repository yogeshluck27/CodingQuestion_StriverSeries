package TreeSeries;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int key) {
		val = key;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode() {
		super();
	}

}
//					1

//			2				3

//		4	   5        6       7

public class BFS {
	//Queue => FIFO 
	//Offer() => adding element in queue
	//peek() => retrieve the first element of queue .Don't remove.
	//poll() => retrieve & remove First element of queue

	public List<List<Integer>> levelOrder(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		if(root==null) return wrapList;
		//At the start add root Add 1 
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelNum = queue.size(); //1  //2,3
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left); //queue = 1,2  // 2,3,4  //3,4,5,6    
				if (queue.peek().right != null)
					queue.add(queue.peek().right);//queue = 1,2,3  // 2,3,4,5 //3,4,5,6,7
				
				subList.add(queue.poll().val); //subList = 1    	//2       //2,3      //4,5,6,7
			}
			wrapList.add(subList); // 1  , 2 3 , 4 5 6 7
		}
		return wrapList;
	}
}
