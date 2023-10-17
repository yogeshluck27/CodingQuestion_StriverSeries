package TreeSeries;

import java.util.ArrayList;
import java.util.List;

//1st case: If BT has no left subtree . left == null then add the root in list & then go to right subtree
//2nd case => 
//Before going to Left & find right most guy on left subtree or last guy in the subtree.
//point that to the root.And then go to left.
//If right most guy is already pointing to the root then remove that pointer ,
//add that node to the list and then go to right. 
//								1

//					2						3
//										
//			4				5
//									
//									6
//
public class MorrisTraversal_BT {

	public List<Integer> getInorder(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();

		TreeNode cur = root;

		while (cur != null) {
			// First Case
			if (cur.left == null) {
				inorder.add(cur.val);
				cur = cur.right;
			} else //second case
				{
				TreeNode prev = cur.left; // cur = 2 prev =4
				while (prev.right != null && prev.right != cur) {
					prev = prev.right; //Go to rightmost guy in left subtree
				}
				if (prev.right == null) { // we reached the rightmost guy
					prev.right = cur; //add thread/pointer to point to cur i.e root
					
					cur = cur.left;		// move to the left
				} else {
					prev.right = null; //We have to cut the link
					inorder.add(cur.val); //add root/cur to list
					cur = cur.right; // move to right subtree
				}
			}
		}

		return inorder;
	}
	
	
	public List<Integer> getPreorder(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();

		TreeNode cur = root;

		while (cur != null) {
			// First Case
			if (cur.left == null) {
				preorder.add(cur.val);
				cur = cur.right;
			} else //second case
				{
				TreeNode prev = cur.left; // cur = 2 prev =4
				while (prev.right != null && prev.right != cur) {
					prev = prev.right; //Go to rightmost guy in left subtree
				}
				if (prev.right == null) { // we reached the rightmost guy
					prev.right = cur; //add thread/pointer to point to cur i.e root
					preorder.add(cur.val); //add root/cur to list
					cur = cur.left;		// move to the left
				} else {
					prev.right = null; //We have to cut the link
					cur = cur.right; // move to right subtree
				}
			}
		}

		return preorder;
	}
}
