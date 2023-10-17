package HouseRobber_1_DP;

import java.util.Arrays;

public class Tabulation {
	/*
	 * Declare a dp[] array of size n. First initialize the base condition
	 * values, i.e dp[0] as 0. Set an iterative loop which traverses the array(
	 * from index 1 to n-1) and for every index calculate pick and nonPick And
	 * then we can set dp[i] = max (pick, nonPick)
	 */

	public static int findMaximumSum(int n, int[] arr, int[] dp) {
		// Base Case
		dp[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {

			int pick = arr[i];
			if (i > 1)
				pick += dp[i - 2]; // this is to handle negative
			
			int notPick = dp[i - 1];
			dp[i] = Integer.max(pick, notPick);

		}
		return dp[n-1];

	}

	public static int maximumSum(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n];
		 Arrays.fill(dp,-1);

		return findMaximumSum(n, arr, dp);

	}

	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3, 1 }));
		System.out.println(
				"Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 2, 7, 9, 3, 1 }));

	}
}
