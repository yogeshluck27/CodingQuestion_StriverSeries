package TreeSeries;

public class LCA_BinaryTree {
//								1
//												
//				2								3
//										
//										4					5
//
//								8				#		6		7
//
//	
// lca(7,8) => 3

	//We will trverse tree using BFS recursive approach
	//Suppose we are at node node 4 , we will check left & right
	//Left is 8 which is one of the matching nodes will return 8.Right point to null so return null
	//So at node 8 ,Left gave us 8 & right gave us null. So final return at node 8 is Null.
	//At node 5, left is not matching so returns null,Right is 7 so matching returns 7.
	//So null and 7 gives us 7 at node 5
	//So at node 3,left subtree gave us 8 & right subtree gave us 7 so will return current node i.e 3
	
	// So algorithm is traverse left & right subtree.& we we try to match the every node for LCA elements.
	//If left node value is matching & right node value is not matching return left value
	//If right is matching & left is not matching return right
	//If both are not matching return null
	//If both are matching then return current node value.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Base Case
		if (root == null || root == p || root == q) { // matching node
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null) { //No need to check if right is null.
			//If its null then it is handled in base case
			//If it has some value then also its handled in base case
			return right;
		} else if (right == null) {
			return left;
		}
		else {
			//Both left & right are not null.we have to return current node as LCA.
			return root;
		}
	}

}
