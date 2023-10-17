package TreeSeries;

import java.util.List;

//IMP Note : Inorder traversal in BST gives us sorted list .

//For finding kth smallest element
//We need to use any traversal technique like morris,recursive,iterative
//And we need to keep a counter
//And once we get the node increment counter and also check if counter is equal to the node 
//we are searching /If yes return the node.

//For finding kth largest element
//Find no of nodes in tree ..suppose its N
//Then we need to search (N-K) th smallest node in given subtree using the approach discussed above
public class KthSmallestAndLargestElementInBST {
	int count = 0;
	int result = Integer.MAX_VALUE;
	
	public int kthSmallest(TreeNode root, int k) {
		inOrderTraversal(root, k);
	    return result;
	}
	
	
	//Left root right
	public void inOrderTraversal(TreeNode node, int k) {

		if (node == null)return;
			
		inOrderTraversal(node.left, k); //Left
		count++;
		if (count == k)      //Root 
			result = node.val;
		inOrderTraversal(node.right, k); //Right

	}
	public int kthLargest(TreeNode root, int k) {
		int N = 10; //total no of nodes in BST
		inOrderTraversal(root, N-k);
	    return result;
	}
	

}
