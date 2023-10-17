package LongestCommon_Subseq_DP;

import java.util.Arrays;

public class Tabulation {

	public static int noOfWays(int index1, int index2, String s1, String s2, int[][] dp) {
		// Base Case
		// Shifted to one right bcoz indexes can be -1/
		// So -1 will be trated as 0
		if (index1 == 0 || index2 == 0)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		// Match
		if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
			return dp[index1][index2] = 1 + noOfWays(index1 - 1, index2 - 1, s1, s2, dp);
		}

		// Not Match

		return dp[index1][index2] = 0
				+ Integer.max(noOfWays(index1 - 1, index2, s1, s2, dp), noOfWays(index1, index2 - 1, s1, s2, dp));

	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int dp[][] = new int[n + 1][m + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return noOfWays(n, m, text1, text2, dp);
	}

	public static int longestCommonSubsequence_Tabulation(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int dp[][] = new int[n + 1][m + 1];
		
		// Rewrite Base Cases
		for (int index1 = 0; index1 <= n; index1++)
			dp[index1][0] = 0;
		for (int index2 = 0; index2 <= m; index2++)
			dp[0][index2] = 0;

		for (int index1 = 1; index1 <= n; index1++) {
			for (int index2 = 1; index2 <= m; index2++) {
				//Match
				if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) 
					dp[index1][index2] = 1 + dp[index1 - 1][ index2 - 1];
				// Not Match
				else
					dp[index1][index2] = 0 + Integer.max(dp[index1 - 1][index2],
							dp[index1][ index2 - 1]);
				
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {

		System.out.println("Length of Longest Common subsequence is : " + longestCommonSubsequence_Tabulation("abcde", "ace"));

		System.out.println("Length of Longest Common subsequence is : " + longestCommonSubsequence_Tabulation("abc", "abc"));

		System.out.println("Length of Longest Common subsequence is : " + longestCommonSubsequence_Tabulation("abc", "def"));
	}

}
