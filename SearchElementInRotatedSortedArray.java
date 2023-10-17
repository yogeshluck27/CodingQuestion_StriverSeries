
public class SearchElementInRotatedSortedArray {
// We divide the array into parts. It is done using two pointers, low and high, 
	//and dividing the range between them by 2
//This gives the midpoint of the range
//Check if the target is present in the midpoint, calculated before, of the array
//If not present, check if the left half of the array is sorted.	
//This implies that binary search can be applied in the left half of the array provided
//the target lies between the value range
//Else check into the right half of the array
// Repeat the above steps until low <= high
//If low > high indicates we have searched the array and the target is not present hence return -1
	
	public static int search(int arr[],int target){
		int low = 0 , high = arr.length-1;
		
		while(low <= high){
			int mid = (low + high) / 2;
			
			if(arr[mid] == target) return mid; // 7 == 0 No
			
			//Check if left side is sorted
			if(arr[low] <= arr[mid]){
				if(target >= arr[low] && target <= arr[mid]){
					high = mid-1;
				}else{
					low = mid+1;
				}
			}
			//Check if right side is sorted or not
			else{
				if(target >= arr[mid] && target <= arr[high]){
					low = mid+1;
				}else{
					high= mid-1;
				}
				
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		//System.out.println("Traget is at posistion : "+ search(new int[]{ 4,5,6,7,0,1,2,3 }, 0));//Left half sorted
		///System.out.println("Traget is at posistion : "+ search(new int[]{ 4,5,6,7,0,1,2 }, 3));	//Left half sorted
		System.out.println("Traget is at posistion : "+ search(new int[]{ 7,8,1,2,3,4,5,6 }, 5));//Left is not sorted
		//System.out.println("Traget is at posistion : "+ search(new int[]{ 7,8,1,2,3,4,5,6 }, 1));//Left is not sorted

		

	}
}
