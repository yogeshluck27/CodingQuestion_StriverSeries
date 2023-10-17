package String_Problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<>();

		func(0, s, path, res);
		return res;
	}
	//If you have given string  as aabb .
	//then start from the 0 index and check if you can partition the string for palindrome
	//so for above example if we try to partion at 0 => a abb 
	//We will partion only in case of palindrome substring. here a is palindrome. so we can do partition
	//And we will call same process for next substring i.e abb
	//And we need to add a to some List
	
	private void func(int index, String s, List<String> path, List<List<String>> res) {

		// Base Case
		if (index == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for (int i = index; i < s.length(); i++) { 
			//check 0 to 0 ,0 to 1 , 0 to 2 then // 1 to 1,1 to 2 ..1 to n etc
			if (isPalindrome(s, index, i)) {
				path.add(s.substring(index, i + 1));
				func(i + 1, s, path, res);
				path.remove(path.size() - 1);
			}

		}

	}

	boolean isPalindrome(String s, int start, int end) {

		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}
