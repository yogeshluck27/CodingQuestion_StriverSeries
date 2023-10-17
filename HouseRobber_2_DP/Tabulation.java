package HouseRobber_2_DP;

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
		return dp[n - 1];

	}

	public static int maximumSum(int[] arr) {

		int[] answer1 = new int[arr.length];
		int[] answer2 = new int[arr.length];

		for (int i = 0; i < arr.length - 1; i++) {
			answer1[i] = arr[i];
		}

		for (int i = 1; i < arr.length; i++) {
			answer2[i] = arr[i];

		}
		int dp[] = new int[answer1.length];
		for (int i = 0; i <= answer1.length - 1; i++) {
			dp[i] = -1;
		}

		int dp1[] = new int[answer2.length];
		for (int i = 0; i <= answer2.length - 1; i++) {
			dp1[i] = -1;
		}

		return Integer.max(findMaximumSum(answer1.length, answer1, dp), findMaximumSum(answer2.length, answer2, dp1));

	}

	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3, 1 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 2, 3, 2 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3 }));
	}
}
