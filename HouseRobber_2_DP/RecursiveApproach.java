package HouseRobber_2_DP;

public class RecursiveApproach {

	public static void main(String[] args) {
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3, 1 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 2, 3, 2 }));
		System.out.println("Maximum Subarray Sum of non adjacent element is : " + maximumSum(new int[] { 1, 2, 3 }));
	}

	public static int maximumSum(int[] arr) {

		int[] answer1 = new int[arr.length];
		int[] answer2 = new int[arr.length];

		for (int i = 0; i < arr.length - 1; i++) {
			answer1[i] = arr[i];
		}

		for (int i = 1; i < arr.length; i++) {
			answer2[i] = arr[i];

		}
		return Integer.max(findMaximumSum(answer1.length - 1, answer1), findMaximumSum(answer2.length - 1, answer2));

	}

	public static int findMaximumSum(int index, int[] arr) {
		// Base Case
		// If we are at first index and move to index 0 by not picking up the
		// element
		if (index == 0)
			return arr[index];

		// If we are at first index and move to index -1 by picking up the
		// element

		if (index < 0)
			return 0;

		// Pick element & go to index-2 as we don't want adjacent elements to be
		// picked up
		int pick = arr[index] + findMaximumSum(index - 2, arr);
		// Not Pick Element
		int notPick = findMaximumSum(index - 1, arr);

		return Integer.max(pick, notPick);

	}

}
