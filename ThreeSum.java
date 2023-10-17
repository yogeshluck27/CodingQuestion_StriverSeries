import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {//We can form triplet till
			// we reach to 3rd last element
													
			if (i==0 || (i >0 && num[i] != num[i - 1])) {//If its the first element in array or
				// To avoid duplicates condition
				
				int low = i + 1, high = num.length - 1, sum = 0 - num[i];
				//Run two pointer approach till low crosses high
				while(low < high){
					
					if (num[low] + num[high] == sum) {
						 ArrayList < Integer > temp = new ArrayList < > ();
						 temp.add(num[i]);
						 temp.add(num[low]);
						 temp.add(num[high]);

						 ans.add(temp);

						while (low < high && num[low] == num[low + 1]) low++; // To Avoid Duplicates
							
						while (low < high && num[high] == num[high - 1]) high--; // To Avoid Duplicates

						low++;
						high--;
						
					} else if (num[low] + num[high] < sum) { // We need to increase the  value
						// to match the sum	Hence increasing low as elements are sorted.									
						low++;
					} else {
						// We need to decrease the element value to match the sum.
						// Hence decreasing high as elements are sorted.
						high--;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		ans = threeSum(new int[] { -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2 });
		 for (int i = 0; i < ans.size(); i++) {
	            for (int j = 0; j < ans.get(i).size(); j++) {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	}
}
