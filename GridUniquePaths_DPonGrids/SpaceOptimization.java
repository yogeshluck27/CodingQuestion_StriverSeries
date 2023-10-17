package GridUniquePaths_DPonGrids;

public class SpaceOptimization {

	//If there is previous row & previous column then we can space optimized .
	//dp[i][j] = dp[i-1][j] + dp[i][j-1]
	
	public static int countWaysUtil(int m, int n) {
	    int prev[]=new int[n]; //previous row

		for (int i = 0; i < m; i++) {
	        int temp[]=new int[n]; //Current row

			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
				temp[j] = 1;
					continue;
				}
				int up = 0;
				int left = 0;

				if (i > 0)
					up = prev[j]; // i-1 replaced by pre
				if (j > 0)
					left = temp[j - 1]; // i replaced by temp

				temp[j] = up + left;
			}
			prev = temp;
		}

		return prev[n - 1]; // m-1 replaced by prev

	}

	static int countWays(int m, int n) {
	
	
		return countWaysUtil(m, n);
	}

	public static void main(String args[]) {

		int m = 3;
		int n = 2;

		System.out.println("No Of ways to reach from (0,0) to (3,2) in 2-D Matrix is : " + countWays(m, n));
	}

}
