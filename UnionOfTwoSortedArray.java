import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArray {
//Input :
//arr1[] = { 1,1,2,3,4,5 }
//arr2[] = { 2,3,4,4,5,6 }
// Union of arr1 & arr2 will be {1,2,3,4,5,6}
	
//Approach 1 : Brute Force
//Use Set to store the element as duplicate elements will not be there
//Copy elements from Set to result array
//TC -> O(n1 logn) + O(n2 logn) + O(n1+n2)  Set & result array
//SC -> O(n1+n2) + o(n1+n2)                 Set & result array

//Approach 2 :

//Take two pointers let’s say i,j pointing to the 0th index of arr1 and arr2.
//Create an empty List for storing the union of arr1 and arr2.
// union is nothing but the distinct elements in arr1 + arr2 
//Let’s traverse the arr1 and arr2 using pointers i and j and insert the distinct elements
//found into the union List
//While traversing we may encounter three cases.
// Case1 : arr1[ i ] == arr2[ j ] 
// we found a common element, so insert only one element in the union
// while inserting always check whether the last element in the union List is equal or not to 
//the element to be inserted.	If yes then dont insert it. 
	
//Case2 : arr1[ i ]  < arr2[ j ]
// need to insert arr1[ i ] in union	
//IF last element in  union List is not equal to arr1[ i ],then insert in union else don’t insert
	// After checking Increment i
//Case2 : arr1[ i ]  > arr2[ j ]
//we need to insert arr2[ j ] in union
//IF the last element in the union vector is not equal to arr2[ j ], then insert in the union, else don’t insert.
//After checking Increment j	

	public static void main(String args[]) {
		  int n = 10, m = 7;
		  int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		  int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		  ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
		  System.out.println("Union of arr1 and arr2 is ");
		  for (int val: Union)
		    System.out.print(val+" ");
		}

	static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
		   int i = 0, j = 0; // pointers
		  ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
		  while (i < n && j < m) {
		    if (arr1[i] <= arr2[j]) // Case 1 and 2
		    {
		      if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
		        Union.add(arr1[i]);
		      i++;
		    } else // case 3
		    {
		      if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
		        Union.add(arr2[j]);
		      j++;
		    }
		  }
		  while (i < n) // IF any element left in arr1
		  {
		    if (Union.get(Union.size()-1) != arr1[i])
		      Union.add(arr1[i]);
		    i++;
		  }
		  while (j < m) // If any elements left in arr2
		  {
		    if (Union.get(Union.size()-1) != arr2[j])
		      Union.add(arr2[j]);
		    j++;
		  }
		  return Union;
		}
	
}
