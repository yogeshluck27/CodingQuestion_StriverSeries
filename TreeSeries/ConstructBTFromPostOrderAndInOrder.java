package TreeSeries;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostOrderAndInOrder {
	//InOrder => [40 , 20 , 50 , 10 ,60 , 30 ]  
	//PostOrder => [40 , 50 ,20 , 60 ,30 ,10]
	
	public TreeNode buildTree(int[] postOrder , int[] inorder){
		if(inorder == null || postOrder == null || inorder.length != postOrder.length) return null;
		Map<Integer,Integer> inmap = new HashMap<Integer,Integer>();
		for(int i = 0 ; i< inorder.length ; i++){
			inmap.put(inorder[i], i);  // { {40,0} , {20,1} , {50,2}  , {10,3} , {60,4} , {30,5} }
		}
		TreeNode root = buildTree(inorder,0,inorder.length-1,postOrder,0,postOrder.length-1,inmap);
		return root;
	}
	public  TreeNode  buildTree(int[] inorder, int instart, int inend ,
			int[] postOrder, int poststart, int postend, Map<Integer, Integer> inmap) {
		
		if(poststart > postend || instart > inend) return null;
		
		TreeNode parent = new TreeNode(postOrder[postend]); //10
		int inRoot = inmap.get(postOrder[postend]); // inRoot = 3
		int numsLeft = inRoot - instart; // 3 - 0 = 3 // 3 elements to left of 10 are Left Subtree
		//and remaining elements to right of 10 are in right substree as per inorder
		parent.left = buildTree(inorder , instart , inRoot -1 , postOrder , poststart , poststart +numsLeft -1 ,inmap);
		parent.right = 	buildTree(inorder,inRoot+1,inend ,postOrder ,poststart+numsLeft, postend-1,inmap);	
		
		return parent;
		
	}
}
