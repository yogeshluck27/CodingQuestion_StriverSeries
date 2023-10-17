package GridUniquePaths_DPonGrids;

import java.util.Arrays;
//SC->Recursive Stack space TC->2^n
public class RecursiveApproach {

	public static void main(String args[]) {

		int m = 3;
		int n = 2;

		System.out.println("No Of ways to reach from (0,0) to (3,2) in 2-D Matrix is : "+countWays(m, n));
		//m is row , n is column
	}

	public static int countWays(int m, int n) {
		return countWaysUtil(m - 1, n - 1); //We will start at end position (2,3) and go till (0,0)

	}
	//
	public static int countWaysUtil(int i, int j) {
		
		//Step 1 ; Base Case
		//When i=0 and j=0, that is we have reached the destination so we can count the current path that is going on, hence we return 1.
		//When i<0 and j<0, it means that we have crossed the boundary of the matrix and we couldn’t find a right path, hence we return 0
		if(i==0 && j==0) return 1; 
		
		if(i<0 || j<0) return 0;
		//As we are writing a top-down recursion, at every index we have two choices,
		//one to go up(↑) and the other to go left(←). 
		//To go upwards, we will reduce i by 1, and move towards left we will reduce j by 1.
		
		int up =  countWaysUtil(i-1,j);
		
		int left = countWaysUtil(i,j-1);
		
		return up + left;

	}

}
