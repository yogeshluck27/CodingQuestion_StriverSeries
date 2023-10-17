package CombinantionSum_DP;

import java.util.ArrayList;
import java.util.List;

public class RecursiveApproach {
	
	public static void findCombinations(int index , int[] candidates,int target,List<List<Integer>> combinations,List<Integer> ds){
		
		//Base 
		if(index == candidates.length){
			if(target == 0){
				combinations.add(new ArrayList<> (ds)); 
			}
			return;
		}
		//Pick
		if(candidates[index] <= target){
			ds.add(candidates[index]);
			findCombinations(index,candidates,target-candidates[index],combinations,ds);
			//When recursion comes back then
			//we need to remove the element we have added earlier
			ds.remove(ds.size() -1);

		}
		findCombinations(index+1,candidates,target,combinations,ds);

		//Not Pick
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> combinations = new ArrayList<>();
		
		findCombinations(0,candidates,target,combinations,new ArrayList<>());
		
		return combinations;
	}
	
	
	public static void main(String[] args) {
		 int arr[] = {2,3,6,7};
	        int target = 7;
	        RecursiveApproach sol = new RecursiveApproach();
	        List < List < Integer >> ls = sol.combinationSum(arr, target);
	        System.out.println("Combinations are: ");
	        for (int i = 0; i < ls.size(); i++) {
	            for (int j = 0; j < ls.get(i).size(); j++) {
	                System.out.print(ls.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	}

}
