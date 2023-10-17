package HouseRobber_1_DP;

public class RecursiveApproach {
	
	
	
	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " +maximumSum(new int[]{1,2,3,1}));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " +maximumSum(new int[]{2,7,9,3,1}));

	}

	public static int maximumSum(int[] arr){
		return findMaximumSum(arr.length -1 ,arr);
		
	}
	public static int findMaximumSum(int index,int[] arr){
		//Base Case
		//If we are at first index and move to index 0 by not picking up the element
		if(index == 0) return arr[index];
		
		//If we are at first index and move to index -1 by picking up the element

		if(index < 0) return 0;
		
		//Pick element & go to index-2 as we don't want adjacent elements to be picked up
		int pick = arr[index] + findMaximumSum(index - 2,arr);
		//Not Pick Element
		int notPick = findMaximumSum(index - 1,arr);
		
		return Integer.max(pick,notPick);
		
	}
	
	
}
