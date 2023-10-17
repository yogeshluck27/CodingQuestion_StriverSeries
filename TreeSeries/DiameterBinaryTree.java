package TreeSeries;

//Maximum of Sum of Left & right height of BT
//No need that it should pass through root
//diameter is an array not variable becoz java is pass by value
public class DiameterBinaryTree {
	
	public int diameterBinaryTree(TreeNode root){
		int[] diameter = new int[1];
		height(root,diameter);
		return diameter[0];
	}

	public int height(TreeNode node, int[] diameter) {
		
		if(node == null) return 0;
	
		int lh = height(node.left,diameter);
		int rh = height(node.right,diameter);
		diameter[0] = Math.max(diameter[0] , lh + rh);
		
		return 1+ Math.max(lh, rh);
		
	}

}
