package TreeSeries;

public class MaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int[] maxValue = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxPathDown(root, maxValue);

		return maxValue[0];
	}

	private int maxPathDown(TreeNode node, int[] maxValue) {

		if(node == null) return 0;
		
		/*int lh =  maxPathDown(node.left , maxValue);
		int rh =  maxPathDown(node.right , maxValue);*/
		
		int lh =  Math.max(0, maxPathDown(node.left , maxValue)); //To avoid negative value node
		int rh =  Math.max(0,maxPathDown(node.right , maxValue)); //To avoid negative value node
		
		maxValue[0] = Math.max(maxValue[0] ,(node.val + lh + rh));
		
		return node.val + Math.max(lh,rh);

	}
}
