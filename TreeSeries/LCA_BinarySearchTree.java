package TreeSeries;

public class LCA_BinarySearchTree {
	
	//In BST ,Root left side elements are smaller than root & right part elements are greater than root
	//So at every point we will check that if current element is less than both elements
	//or greater than both elements 
	//Or less than 1 & greater than other
	//Or itself is one of the LCA element
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p , TreeNode q){
		if(root == null) return null;
		
		int curr = root.val;
		
		if(curr < p.val && curr < q.val){
			lowestCommonAncestor(root.right,p,q);
		}else if(curr > p.val && curr > q.val){
			lowestCommonAncestor(root.left,p,q);
		}
		
		return root; //If current element is itself a part of LCA or
					//1 of the LCA elements lie on left & other element lie on right
		
	}
}
