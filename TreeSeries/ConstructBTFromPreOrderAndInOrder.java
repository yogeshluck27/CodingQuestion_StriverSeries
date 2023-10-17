package TreeSeries;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreOrderAndInOrder {

	//InOrder => [9 , 3 , 15 , 20 ,7 ]
	//PreOrder => [3, 9 , 20 ,15 , 7]
	
	//InOrder => [40 , 20 , 50 , 10 ,60 , 30 ]  => this is better example
	//PreOrder => [10, 20 , 40 ,50 , 30 , 60]
	public TreeNode buildTree(int [] preorder , int[] inorder){
		Map<Integer,Integer> inmap = new HashMap<Integer,Integer>();
		for(int i=0 ; i < inorder.length ; i++){
			inmap.put(inorder[i], i);
			// map = { {9,0 } , { 3,1 } , { 15,2 } , { 20, 3} , {7,4} }
			// map = { {40,0 } , {20,1 } , { 50,2 } , { 10, 3} , {60,4} , {30 ,5} }
		}
		TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);
		return root;
	}
	public TreeNode buildTree(int[] preorder, int prestart, int preend,
				int[] inorder, int instart, int inend, Map<Integer, Integer> inmap) {
		
		if(prestart > preend || instart > inend) return null;
		TreeNode root = new TreeNode(preorder[0]);
		int inRoot = inmap.get(root.val);  // map.get(10) => 3
		int numsLeft = inRoot - instart ;  //3-0 = 3 ; no of elements to the left in InOrder array
		
		root.left = buildTree(preorder, prestart+1, prestart+numsLeft, inorder, instart , inRoot - 1, inmap);
		
		root.right = buildTree(preorder,prestart+numsLeft+1,preend,inorder,inRoot+1, inend,inmap);
		
		return root;
	}
}
