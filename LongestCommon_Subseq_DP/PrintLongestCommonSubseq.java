package LongestCommon_Subseq_DP;

import java.util.Arrays;

public class PrintLongestCommonSubseq {
	
	public static void main(String[] args) {

		 print_longestCommonSubsequence_Tabulation("abcde", "ace");

		print_longestCommonSubsequence_Tabulation("abc", "abc");

		print_longestCommonSubsequence_Tabulation("abc", "def");
	}

	
	
	public static void print_longestCommonSubsequence_Tabulation(String text1, String text2) {
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

		int len =  dp[n][m];
		StringBuffer ans = new StringBuffer();
		for(int i =0 ;i<len;i++){
			ans.append("$");
		}
		
		int index = len-1;
		//Iterate dp[][] array from last to first index n,m to 0,0
		//LCS length is at last position i.e dp[n][m]
		//We will match the character of both string if it matches then we will reduce both i  j
		//As well as set answer string character accordingly
		//If it does not match we need to move same column prev row or same row prev column
		//And then compare the values of dp matrix
		int i=n ,j=m;
		
		while(i>0 && j>0){
			if(text1.charAt(i - 1) == text2.charAt(j - 1)){
				ans.setCharAt(index, text1.charAt(i-1));
				index--;
				i --; j--;
			}else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}else{
				j--;
			}
		}
		System.out.println("Answer is "+ans);
	}
}
