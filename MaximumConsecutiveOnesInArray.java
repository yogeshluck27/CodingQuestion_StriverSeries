
public class MaximumConsecutiveOnesInArray {

	public static void main(String[] args) {
		int[] arr={11,111,0,0,1,1,1,0,0,1,1,0,1,1,1,1};
		findMaximumConsecutiveOnes(arr);
	}
	//TC -> O(N)
	//SC -> O(1)
	private static void findMaximumConsecutiveOnes(int[] arr) {
		int maxi = 0;
		int counter = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == 1){
				counter++;
				maxi=Integer.max(maxi, counter);
			}else{
					counter =0;
			}
		}
		System.out.println("findMaximumConsecutiveOnes " +maxi);
	}
}
