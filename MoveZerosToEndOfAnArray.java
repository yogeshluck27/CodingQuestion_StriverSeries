


//Brute Force Approach
//input : arr[] = {1,0,2,3,2,0,0,4,5,1} ; temp[] ={}
//Output :arr[] = {1,2,3,2,4,5,1,0,0,0}
//Step 1 : Take a temp arr . copy all non zero elements from arr to temp.
//Step 2 : Copy elements from temp to arr


//Optimal Approach is : 2 pointer 
//Step 1 : find the index of First zero element ; assign j with that index
//Step 2 : Iterate arr from j+1 till end 
// While iterating if we encounter non zero element then swap arr[i] and arr[j] And do j++
//If we encounter 0 element then no swap
// we are always moving i pointer by one
//j pointer will be always pointing to 0
public class MoveZerosToEndOfAnArray {
	
	public static void main(String[] args) {
		int arr[] = {1,0,2,3,2,0,0,4,5,1} ;
		int n = arr.length;
		System.out.print("Initial Array ");

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();	

		moveZerosToEndOfArray(arr,n);
		System.out.print("After movinng zeros to end of an array ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();	
		}

	private static void moveZerosToEndOfArray(int[] arr, int n) {
		int j = -1;
		//Step 1 : find the index of First zero element ; assign j with that index
		
		for(int i = 0 ;i < n;i++){
			if(arr[i] == 0){
				j = i;
				break;
			}
		}
		//This is when there is no zero
		if(j == -1) return ;
		//Step 2 : If we encounter non zero element then swap arr[i] and arr[j] And do j++ 

		for(int i = j+1 ;i < n;i++){
			if(arr[i] != 0){
				swap(i,j,arr);
				j++;
			}
		}
		
	}

	private static void swap(int num1, int num2 , int arr[]) {

		int temp = arr[num1];
		arr[num1]= arr[num2];
		arr[num2] = temp;
		
	}
	
}
