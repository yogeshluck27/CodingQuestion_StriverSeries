package TreeSeries;
//														10
//									5										15
//							2			8								13		17
//						#		#	6		#						#		# #     #

public class BSTFloor {
	//We need to find a greatest value in BST which is smaller than key.
	//Key IS 9 => floor is 8
	public static int findFloor(TreeNode root,int key){
		int floor = -1;
		while(root != null){
			if(root.val == key){
				floor = root.val;
				return floor;
			}
			if(root.val > key){
				floor = root.val; // 5 //8
				root = root.right; //As we need greatest value smaller than key. 
				//So we have to assign the value before moving to right
			}
			else{
				root = root.left;
			}
			 
		}
		return floor;
	}
}
