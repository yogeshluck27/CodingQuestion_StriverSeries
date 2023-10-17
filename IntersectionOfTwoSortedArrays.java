import java.util.ArrayList;

//Algorithm : Two pointer Approach
//Take two pinter one at start of aar1 and other at start of arr2
//Compare elements at both pointer.Three Cases possible
//Case 1 : arr1[i] < arr2[j] , we need to move i one positiin ahead
//Case 2 : arr1[j] < arr2[i]  ,we need to move j one positiin ahead
//Case 3 : arr1[j] = arr2[i]  , we got intersection add elements to result list and move both pointers
public class IntersectionOfTwoSortedArrays {
	public static void main(String args[]) {
		int n = 10, m = 7;
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
		ArrayList<Integer> intersection = FindIntersection(arr1, arr2, n, m);
		System.out.println("Intersection of arr1 and arr2 is ");
		for (int val : intersection)
			System.out.print(val + " ");
	}

	static ArrayList<Integer> FindIntersection(int arr1[], int arr2[], int n, int m) {
		int i = 0, j = 0; // pointers
		ArrayList<Integer> intersection = new ArrayList<>(); 
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) 
			{
				i++;
			} else if (arr1[j] < arr2[i]) 
			{
				j++;
			}
			else{
				intersection.add(arr1[i]);
				i++;j++;
				
			}
		}
		return intersection;
	}

}
