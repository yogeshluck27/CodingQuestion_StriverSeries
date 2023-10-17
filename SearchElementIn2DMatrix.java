import java.util.ArrayList;
import java.util.Arrays;

public class SearchElementIn2DMatrix {

	public static boolean searchElement(ArrayList<ArrayList<Integer>> matrix, int target) {
		int n = matrix.size();
		//For every row perform binary search
		for (int i = 0; i < n; i++) {
			boolean flag = binarySearch(matrix.get(i), target);
			if (flag == true)
				return true;
		}
		return false;

	}

	public static boolean binarySearch(ArrayList<Integer> nums, int target) {
		int n = nums.size(); // size of the array
		int low = 0, high = n - 1;

		// Perform the steps of binary search:
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums.get(mid) == target)
				return true;
			else if (target > nums.get(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}

	public static boolean searchElementConvertTo1DArray(ArrayList<ArrayList<Integer>> matrix, int target) {
		int n = matrix.size();
		int m = matrix.get(0).size();
		int low = 0, high = n*m-1; // this is last index of 2D array
		//We are converting 2D arrayList in 1D array in imagination.
		//So row will be calculated as mid/m and column as mid % m
		while (low <= high) {
			int mid = (low + high) / 2;
			int row = mid/m;  //
			int col = mid % m;
			if(matrix.get(row).get(col) == target){
				return true;
			}else if (matrix.get(row).get(col) < target) {
				low = mid + 1;
				
			}else {
				high = mid -1;
			}
		}
		return false;

	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
		matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
		matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
		matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
		matrix.add(new ArrayList<>(Arrays.asList(18, 21, 23, 26, 30)));

		boolean result = searchElement(matrix, 26);
		System.out.println(result ? "true" : "false");
		
		boolean resultUsing1DArray = searchElementConvertTo1DArray(matrix, 26);
		System.out.println(resultUsing1DArray ? "true" : "false");

	}
}
