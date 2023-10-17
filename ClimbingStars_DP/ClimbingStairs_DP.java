package ClimbingStars_DP;


public class ClimbingStairs_DP {
	//Start from the top
	//Either you can jump step 1 or step 2
	//If you reaches to zero then return 1
	//If you are at 1st stair then you can jump only step 1 
	 public int climbStairs(int n) {
		 
		 if(n==0) return 1;
		 if(n==1) return 1;
		 
		 return climbStairs(n-1) + climbStairs(n-2);
	        
	    }
	 //Steps for the Tabulation approach
	 //Step 1 : Declare a dp[] array of size n+1.
	 //Step 2 : First initialize the base condition values,
	 //i.e i=0 and i=1 of the dp array as 1.
	 //Step 3 : Set an iterative loop that traverses the array( from index 2 to n) and
	  // for every index set its value as dp[i-1] + dp[i-2]. 
	 
	 public int[] climbStairsUsingDP(int n) {
		 
		 
	 int dp[] = new int[n+1];
	 dp[0]=1;
	 dp[1]=1;
	 
	 for(int i=2;i<=n;i++){
		 
		 dp[i]=dp[i-1]+dp[i-2];
	 }
	 return dp;
	 }
}

