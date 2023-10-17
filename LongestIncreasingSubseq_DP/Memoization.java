package LongestIncreasingSubseq_DP;

import java.util.Arrays;

public class Memoization {

	// index -> 0 to n-1
	// prev index =-> -1 to n-1
	// How to store -1 ? coordinate change ? Yes
	// prev index => 0 to N
	// So 2-d Array will be dp[N][N+1]

	public static int calculatenoOfWays(int index, int prev_index, int arr[], int n, long[][] dp) {

		// Base Case
		if (index == n) {
			return 0;
		}
		
		if (dp[index][prev_index + 1] != -1)
			return (int) (dp[index][prev_index + 1]);
		//Not Take 
		int length = (int) (0 + calculatenoOfWays(index + 1, prev_index, arr, n, dp));
		//Take
		if (prev_index == -1 || arr[index] > arr[prev_index]) {
			length = Integer.max(length, (1 + calculatenoOfWays(index + 1, index, arr, n, dp)));

		}
		return (int) (dp[index][prev_index + 1] = length);
	}

	static long calculate_longestSubsequence(int[] arr, int n) {

		long dp[][] = new long[n][n + 1];
		for (long row[] : dp)
			Arrays.fill(row, -1);

		return calculatenoOfWays(0, -1, arr, n, dp);
	}

	public static void main(String[] args) {

		System.out.println(calculate_longestSubsequence(new int[] { 5, 4, 11, 1, 16, 8 }, 5));
	}
}
