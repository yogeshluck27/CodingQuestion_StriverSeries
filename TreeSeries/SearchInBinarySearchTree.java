package TreeSeries;

public class SearchInBinarySearchTree {

	//BST is tree where Left Node val < root val < right node val
	//So we dont want to search for entire tree
	//Hence TC is Log N => which is height of BST
	public TreeNode searchBST(TreeNode root,int val){
		
	/*	if(root == null) return null;
		if(root.val == val) return root;
		else if(root.val < val ) searchBST(root.left,val);
		else searchBST(root.right,val);*/
		
		while(root !=null && root.val != val){
			root = val<root.val ? root.left : root.right;
		}
		return root;
	}
}
