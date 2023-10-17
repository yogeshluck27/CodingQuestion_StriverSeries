package HouseRobber_2_DP;

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
		
		int[] answer1 = new int[arr.length];
		int[] answer2 = new int[arr.length];

		for (int i = 0; i < arr.length - 1; i++) {
			answer1[i] = arr[i];
		}

		for (int i = 1; i < arr.length; i++) {
			answer2[i] = arr[i];

		}
	
		int dp[] = new int[answer1.length];
		for(int i = 0; i<= answer1.length-1;i++){
			dp[i] = -1;
		}
		
		int dp1[] = new int[answer2.length];
		for(int i = 0; i<= answer2.length-1;i++){
			dp1[i] = -1;
		}
		return Integer.max(findMaximumSum(answer1.length-1 ,answer1,dp), findMaximumSum(answer2.length-1 ,answer2,dp1));
		
	}
	

	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3, 1 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 2, 3, 2 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3 }));

	}
}
