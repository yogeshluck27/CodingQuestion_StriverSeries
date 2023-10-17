import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_Element {

	public static boolean checkDuplicate(int[] arr){
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		if(set.size() == arr.length){
			return false;

		}
		return true;
		
	}
	public static void main(String[] args) {
		System.out.println(checkDuplicate(new int[]{1, 2, 3, 1}));
		System.out.println(checkDuplicate(new int[]{1, 2, 3,4}));

	}
}
