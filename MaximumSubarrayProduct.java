
public class MaximumSubarrayProduct {

	public static int subArrayWithMaxProduct(int[] arr) {
		int ans = Integer.MAX_VALUE;
		int pref = 1, suff = 1;
		int n = arr.length;
		
		// How to handle even and odd no of negatives in the array.
		// we will be doing multiplication of array elements from start and back
		// whichever will give the maximum that is the answer

		// If we encounter zero then we will treat it as 1 bcoz if we carry zero
		// then ans will become zero

		for (int i = 0; i < n; i++) {
			if (pref == 0)
				pref = 1;
			if (suff == 0)
				suff = 1;

			pref = pref * arr[i];
			suff = suff * arr[n - i - 1]; // n-0-1 , n-1-1 , n-2-1 & so on

			ans = Integer.max(pref, suff);

		}

		return ans;

	}

	public static void main(String[] args) {

		System.out.println("Maximum subarray Sum is " + subArrayWithMaxProduct(new int[] { 1, 2, -3, 0, -4, -5 }));
		System.out.println("Maximum subarray Sum is " + subArrayWithMaxProduct(new int[] { 1, 2, 3, 4, 5, 0 }));

	}
}
