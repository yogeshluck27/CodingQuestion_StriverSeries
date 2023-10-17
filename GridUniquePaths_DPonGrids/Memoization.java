package GridUniquePaths_DPonGrids;

import java.util.Arrays;
//Dynamic programming is possible in case of overlapping subproblems
//If we check the recursion tree then we can see the overlapping states.
//Create a dp array of size [m][n]
//Whenever we want to find the answer of a particular row and column (say f(i,j)),
//we first check whether the answer is already calculated using the dp array(i.e dp[i][j]!= -1 ). 
//If yes, simply return the value from the dp array.
//If not, then we are finding the answer for the given values for the first time, 
//we will use the recursive relation as usual but before returning from the function, 
//we will set dp[i][j] to the solution we get. to compute its value.
//TC -> O(n*m) SC-> O(n-1) + (m-1)) + O(n*m)
public class Memoization {

	public static int countWaysUtil(int i, int j, int[][] dp) {

		// Base condition

		if (i == 0 && j == 0)
			return 1;

		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j]; // If value is already calculated then use that value
								

		int up = countWaysUtil(i - 1, j, dp);

		int left = countWaysUtil(i, j - 1, dp);

		return dp[i][j] = up + left;

	}

	static int countWays(int m, int n) {
		int dp[][] = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return countWaysUtil(m - 1, n - 1, dp);
	}

	public static void main(String args[]) {

		int m = 3;
		int n = 2;

		System.out.println("No Of ways to reach from (0,0) to (3,2) in 2-D Matrix is : "+countWays(m, n));
	}
}
