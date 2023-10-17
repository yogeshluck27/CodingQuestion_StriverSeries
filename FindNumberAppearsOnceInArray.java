
public class FindNumberAppearsOnceInArray {
	// Algorithm : Use XOR operator . It has below rules
	// XOR of any number with itself returns zero
	// XOR of any number with zero returns that number.
	//TC is O(n) . SC-> O(1)
	
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 8, 8 };
		System.out.println(getSingleElement(arr));
		
	}

	private static int getSingleElement(int[] arr) {
		int XOR = 0;
		for (int i = 0; i < arr.length; i++) {
			XOR = XOR ^ arr[i];
		}
		return XOR;
	}
}
