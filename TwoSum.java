import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	//Approach :  Using HashMap when we need the index of elements making the required sum
	// Input[2,7,11,15] target=9 result =[0,1]
	// Input[2,6,5,8,11] target=14 result =[3,1]
	
	//Take a hashMpa: we will be storing element and its corresponding index in HashMap
	//Iterate on an array :
	//Check if element is present in array .If its not then add element as key & its index as value.
	//If element is present ,add the value of map in pair
	//also add the current index of an array 
	//TC-> NlogN  SC->O(N)
	//Map-> (2,0) (6,1) (5,2)
	//When we ar at element 8 in array . we will check if 14-8 = 6 is present in array or not
	//Yes.so we will take current index of array i.e 3
	//And also we will use map.get(6) => 1.which is index of element 6
	//So pair will be [3,1]
	public static int[] twoSum(int numbers[], int target) {

		int result[] = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {

			if (map.get(target - numbers[i]) != null) {
				result[0] = map.get(target - numbers[i]);
				result[1] = i;
			}
			map.put(numbers[i], i); // 2,0  //3,1
		}
		return result;

	}
	public static void main(String[] args) {
		int input[] = new int[] { 2, 7, 11, 15 };

		int result[] = twoSum(input, 9);
		for (int i = 0; i < 2; i++) {
			System.out.println(result[i]);
		}
		
		System.out.println("Array conisst of two elements which meet to Give Target "+
				checkTwoSum(input.length,input,9));

	}
	// Input[2,6,5,8,11] target=14 result = YES
	//First we will sort array .arr [2,5,6,8,11]
	//left = 0 right =4  .. we need to iterate till right crosses left
	//arr[0]+arr[4] == 14 ? return YES
	//If this sum is less than 14 (target) then we need to increase left pointer
	//Else if sum is greater than 14 (target)then we need to decrease  right pointer
	
	public static String checkTwoSum(int n,int[] arr,int target){
		int left = 0; int right = n-1;
		Arrays.sort(arr);
		
		while(left < right){
			int sum = arr[left] + arr[right];
			if(sum == target) return "YES";
			else if (sum < target) left++;
			else right--;
			
		}
		return "NO";
		
	}
}
