package GridUniquePaths_DPonGrids;

import java.util.Arrays;

public class Tabulation {
	//Tabulation is Bottom Up Approach .You start from Base case and then go up
	//Whereas in Recursion is Top Down. Top guy will get answer by going down
	//Step 1 : Declare Base Case
	//Step 2 : express all states in for loops
	//Step 3: Copy the recurrenace and write
	//TC -> O(m*n)  SC-> O(m*n) no recursion stack space
	public static int countWaysUtil(int m, int n, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//Write Base Case
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}
				//Copy recursion
				int up = 0;
				int left = 0;

				if (i > 0)
					up = dp[i - 1][j]; // i-1 can go negative
				if (j > 0)
					left = dp[i][j - 1]; // j-1 can go negative

				dp[i][j] = up + left;
			}
		}
		//Return last element
		return dp[m - 1][n - 1];

	}

	static int countWays(int m, int n) {
		int dp[][] = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return countWaysUtil(m, n, dp);
	}

	public static void main(String args[]) {

		int m = 3;
		int n = 2;

		System.out.println("No Of ways to reach from (0,0) to (3,2) in 2-D Matrix is : " + countWays(m, n));
	}
}
