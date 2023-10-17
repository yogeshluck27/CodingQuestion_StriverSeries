package HouseRobber_1_DP;

import java.util.Arrays;

public class Memoization {

	public static int findMaximumSum(int index,int[] arr,int[] dp){
		//Base Case
		//If we are at first index and move to index 0 by not picking up the element
		if(index == 0) return arr[index];
		//If we are at first index and move to index -1 by picking up the element
		if(index < 0) return 0;
		
		if(dp[index]!=-1) return dp[index];
			
		
		//Pick element & go to index-2 as we don't want adjacent elements to be picked up
		int pick = arr[index] + findMaximumSum(index - 2,arr,dp);
		//Not Pick Element
		int notPick = findMaximumSum(index - 1,arr,dp);
		
		return dp[index] = Integer.max(pick,notPick);
		
	}
	

	public static int maximumSum(int[] arr){
		int n = arr.length;
		int dp[] = new int[n];
		for(int i = 0; i<= n-1;i++){
			dp[i] = -1;
		}
		
		return findMaximumSum(n-1 ,arr,dp);
		
	}
	

	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " +maximumSum(new int[]{1,2,3,1}));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " +maximumSum(new int[]{2,7,9,3,1}));

	}
}
