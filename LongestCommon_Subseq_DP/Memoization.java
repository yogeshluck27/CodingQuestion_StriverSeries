package LongestCommon_Subseq_DP;

import java.util.Arrays;

public class Memoization {

	

	public static int noOfWays(int index1, int index2, String s1, String s2,int[][] dp) {
		// Base Case
		if (index1 < 0 || index2 < 0)
			return 0;
		
		if(dp[index1][index2] != -1) return dp[index1][index2];
			
		
		// Match
		if (s1.charAt(index1) == s2.charAt(index2)) {
			return dp[index1][index2] = 1 + noOfWays(index1 - 1, index2 - 1, s1, s2,dp);
		}

		// Not Match

		return dp[index1][index2] = 0 + Integer.max(noOfWays(index1 - 1, index2, s1, s2,dp), 
								noOfWays(index1, index2 - 1, s1, s2,dp));

	}

	public static int  longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();
		
		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return noOfWays(n-1,m-1,text1, text2,dp);	
		}
	
	public static void main(String[] args) {

		System.out.println("Length of Longest Common subsequence is : " +
		longestCommonSubsequence("abcde", "ace"));

		System.out.println("Length of Longest Common subsequence is : " +
		longestCommonSubsequence("abc", "abc"));

		System.out.println("Length of Longest Common subsequence is : " +
		longestCommonSubsequence("abc", "def"));
	}

}
