//Problem Statement: 
//Given an array of N + 1 size, where each element is between 1 and N. 
//Assuming there is only one duplicate number, your task is to find the duplicate number.
//Input: arr=[1,3,4,2,2]
//Output: 2
//Input: [3,1,3,4,2]
//Output:3

//Solution 2:Using frequency array
//Approach: Take a frequency array of size N+1 and initialize it to 0.
//Now traverse through the array and if the frequency of the element is 0 increase it by 1,
//else if the frequency is not 0 then that element is the required answer.
//Time Complexity: O(N) & Space Complexity: O(N), as we are using extra space for frequency array.


public class FindDuplicateInArray {
	 public static void main(String args[]) {
	        int arr[] = {1,3,4,2,3}; 
	        //freq[] = {0,0,0,0,0,0}  //Initial stage
	        //freq[] = {0,1,1,1,1,0}
	        //index		0 1 2 3 4 5
	        System.out.println("The duplicate element is " + findDuplicate(arr));
	    }

	private static int  findDuplicate(int[] arr) {
		int[] freq = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			if(freq[arr[i]] == 0){
				freq[arr[i]] += 1;
			}else{
				return arr[i];
			}
			
		}
		return 0;
	}
}
