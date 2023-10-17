package String_Problems;

import java.util.HashMap;
import java.util.Map;

//Input = a b c a a b c d b a 
//Output = c d b a
//We will take left & right pointer & Map to store character & its position
//at first left & right is 0. Length is 0. 
// We will keep on moving right pointer by 1 & store the character in map with its index
//As soon as we encounter repeating value in map.
//We will first check the index of that char lie in the current range If yes then move left to index +1 And also update index
//Else we will only update index 
//Do this process till right reaches to end of string.

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s){
		int left = 0,right=0;
		int len =0;
		int n = s.length();
		Map<Character,Integer> map = new HashMap<>(); 
		while(right < n){
			if(map.containsKey(s.charAt(right))){ 
				left = Math.max(left, map.get(s.charAt(right) + 1)); //Range check
			}
			map.put(s.charAt(right) , right );
			len = Math.max(len, right - left +1);
			right ++; 
		}
		return len;
		
	}
}
