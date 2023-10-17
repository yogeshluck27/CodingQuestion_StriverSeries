
public class FindMinimumInRotatedSortedArray {
	
	//We take a left pointer, a right pointer, and a mid. 
	//So if the left side is sorted, then the leftmost element is the smallest in that part.
	//So we update our minVal and check on the right side. 
	//If the right part is sorted then mid is going to be the smallest value for that part,
	//we update the result as min(mid,minVal).
	//To know which part is sorted, We can observe that while rotation we are bringing the largest element ahead,
	//so if nums[mid] >= nums[left],i.e, if an element greater than it exists further in the array, 
	//then that part is sorted. 
	//Else we know the right part is sorted. Because at all times at least one side will be sorted.
	//Which ever part is sorted we take minimum of that part & eliminate it

	public static int findMinimum(int arr[]){
		int low = 0 , high = arr.length-1;
		int min = Integer.MAX_VALUE;
		
		while(low <= high){
			int mid = (low + high) / 2;
			
			//Check if left side is sorted.If yes take leftmmost element as min & eliminate that part/
			if(arr[low] <= arr[mid]){
				min = Integer.min(min, arr[low]); // As all elements are sorted //Leftmost is the smallest one
				low = mid +1;
			}
			//Check if right side is sorted or not . If yes then mid element is the smallest one
			//And eliminate that part
			else{
				high = mid -1;
				min = Integer.min(min, arr[mid]);
				
			}
		}
		return min;
	}
	public static void main(String[] args) {
		System.out.println("Smallest Element in rotated Subarray is  : "+ findMinimum(new int[]{ 4,5,6,7,0,1,2,3 }));//Left half sorted
		System.out.println("Smallest Element in rotated Subarray is  : "+ findMinimum(new int[]{ 4,5,6,7,0,1,2 }));	//Left half sorted
		System.out.println("Smallest Element in rotated Subarray is  : "+ findMinimum(new int[]{ 7,8,1,2,3,4,5,6 }));//Left is not sorted
		System.out.println("Smallest Element in rotated Subarray is  : "+ findMinimum(new int[]{ 7,8,1,2,3,4,5,6 }));//Left is not sorted

		

	}
}
