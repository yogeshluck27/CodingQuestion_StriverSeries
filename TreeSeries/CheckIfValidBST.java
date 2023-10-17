package TreeSeries;

public class CheckIfValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		//BASE CASE
		if(root == null) return true;
		if(root.val >= maxValue || root.val <= minValue) return false;
		//Recursive call to move to left & right with proper range
		return isValidBST(root.left,minValue,root.val) && isValidBST(root.right,root.val,maxValue);
		
	}
}
