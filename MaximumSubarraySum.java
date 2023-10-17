
public class MaximumSubarraySum {

	//Input = -2,-3,4,-1,-2,1,5,-3
	//Output is 7
	//Algorithm is Kadanae's Algo
	//Carry the subarray sum only if its positive
	//Take two variable sum = 0 and maxi=arr[0]
	//Iterate through entire array :
	//At every iteration , add the element one by one in sum
	//if sum > max then max = sum and if sum < 0, mark sum as 0.bcoz no point in carrying negative sum
	//Maxi variable contains maximum subarry sum
	//TC -> O(N)  SC-> O(1)
	public static int maxSubarraySum(int[] arr, int n) {
		int maxi = Integer.MIN_VALUE;
		int sum = 0;
		int start = 0;
		int ansStart=-1,ansEnd=-1;
		for (int i = 0; i < n; i++) {
			if(sum == 0) start = i;
			
			sum += arr[i];

			if (sum > maxi) {
				maxi = sum;
				ansStart = start; // initial position where the sum has been zero.
				ansEnd = i; // Current position of array
			}
			if (sum < 0) {
				sum = 0;
			}

		}
		
		System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("] ");
        
		return maxi;
	}

	public static void main(String[] args) {

		System.out.println("Maximum Subarray Sum " + maxSubarraySum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 8));
		System.out.println("Maximum Subarray Sum " + maxSubarraySum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 9));

	}
}
