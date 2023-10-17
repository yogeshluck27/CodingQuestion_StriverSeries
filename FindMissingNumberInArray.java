
public class FindMissingNumberInArray {
	//Input : arr[] ={ 1,2,4,5 }
	//Output : missing Number is 3
	//Approach : Using Sum of first n natural numbers; 
	//Approach : Using XOR 
	
	public static void main(String[] args) {
		
	
		int arr[] = { 1,2,4,5 };
		findMissingNumber(arr);
		findMissingNumberUsingXOR(arr);
		findMissingNumberUsingXOROneLoop(arr);
	}

	private static void findMissingNumberUsingXOR(int[] arr) {
		int XOR1=0;
		// 1^1 = 0  , 2^2 =0 and so on
		//1^0 = 1  , 5^0 =5
		int n = arr[arr.length-1];
		for(int i=1 ; i<=n ; i++){  // 1^2^3^4^5
			XOR1 = XOR1 ^ i;
		}
		int XOR2=0;
		for(int i=0 ; i<arr.length ; i++){ // 0^1^2^4^5
			XOR2 = XOR2 ^ arr[i];
		}
		int missingNumber = XOR1 ^ XOR2; // 1^2^3^4^5 ^ 0^1^2^4^5 = 3
		System.out.println("Missing Number is " + missingNumber);		

	}
	private static void findMissingNumberUsingXOROneLoop(int[] arr) {
		int XOR1=0;
		int XOR2=0;
		int n = arr[arr.length-1]; //5
		
		for(int i=0 ; i< n-1 ; i++){ //i -> 0 to 3
			XOR2 = XOR2 ^ arr[i]; // 0^1^2^4^5
			XOR1 = XOR1 ^ (i+1); // 1^2^3^4
		}
		XOR1 = XOR1 ^ n; //1^2^3^4^5
		int missingNumber = XOR1 ^ XOR2; // 0^1^2^4^5 ^ 1^2^3^4^5 = 3
		System.out.println("Missing Number is " + missingNumber);		

	}

	private static void findMissingNumber(int[] arr) {
		int n = arr[arr.length-1];
		int expectedSum = n * (n+1)/2;
		int actualSum = 0;
		for(int i=0;i<arr.length;i++){
			actualSum+=arr[i];
		}
		System.out.println("Missing Number is " + (expectedSum - actualSum));		
	}
	
}
