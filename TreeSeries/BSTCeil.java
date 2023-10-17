package TreeSeries;
//														10
//									5										13
//							3			6								11		14
//						2		4	#		9						#		# #     #

public class BSTCeil {
	//We need to find a smallest value in BST which is greater than key.
	//KEY IS 8 => ceil is 9
	//Key is 12 => ceil is 13
	public static int findCeil(TreeNode root,int key){
		int ceil = -1;
		while(root !=null){
			if(root.val == key){
				ceil = root.val;
				return ceil;
			}
			 if (key > root.val){
				root = root.right;
				
			}else{
				ceil = root.val; //As we need smallest value greater than key. So not added this line in key>root.val
				//And we have to assign the value before moving to left
				root = root.left;
			}
		}
		return ceil;
	}
}
