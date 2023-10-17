import java.util.ArrayList;
import java.util.Collections;

//Input :   int arr[]=  {10, 22, 12, 3, 0, 6};
//Leaders : 22 , 12 , 6
//Algorithm:
//First, we’ll start the traversal from the right. Then, we move toward the left. 
//Whenever we encounter a new element, we check with the greatest element obtained so far.
//If the current element is greater than the greatest so far, 
//then the current element is one of the leaders and we update the greatest element
//Else, we proceed with the further elements on the left.
//This method prints the leaders in the reverse direction of their occurrences.
public class LeadersInArray {
	public static void main(String[] args) {
		// Array Initialization.
		int n = 6;
		int arr[] = { 10, 22, 12, 3, 0, 6 };
		ArrayList<Integer> ans = printLeaders(arr, n);

		Collections.sort(ans, Collections.reverseOrder());

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private static ArrayList<Integer> printLeaders(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		// Last element of an array is always a leader,
		// push into ans array.
		int max = arr[n - 1];
		ans.add(arr[n - 1]);
		// Start checking from the end whether a number is greater
		// than max no. from right, hence leader.
		for (int i = n - 2; i >= 0; i--)
			if (arr[i] > max) {
				ans.add(arr[i]);
				max = arr[i];
			}
		return ans;
	}
}
