package CoinChange2_DP;

public class Coin_Change_2_DP {

	public int noOfWays(int arr[], int index, int target) {
		//Base Case
		if (index == 0) {
			if (target % arr[index] == 0) {
				return 1;
			} else
				return 0;
		}

		int notTake = noOfWays(arr, index - 1, target);

		int take = 0;

		// Find All possible ways so we do not decrease index
		// We will be on same index as we can take same element multiple times

		if (arr[index] <= target) {
			take = noOfWays(arr, index, target - arr[index]);
		}

		return take + notTake;

	}
}
