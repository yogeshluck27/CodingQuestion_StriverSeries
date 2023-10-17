package TreeSeries;

public class CheckIdenticalTrees {

	public boolean isIdenticalTree(TreeNode p,TreeNode q){
		if(p == null || q ==null)
			return (p==q);
		
		return (p.val == q.val) && isIdenticalTree(p.left,q.left) && isIdenticalTree(p.right, q.right);
		
	}
}
