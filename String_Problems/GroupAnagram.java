package String_Problems;
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//typically using all the original letters exactly once.

//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//Approach : 
//We need to take every string & convert it to CharArray .And Sort that charArry 
//Take a map . Key of it will be sorted charArray (Converted to String). 
//Value will be List of Strings which has exact letters in key
//Map => key= aet value= eat , tea , ate
//At the end
 public class GroupAnagram {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	Map<String,List<String>> map = new HashMap<>();
	    	for(String str : strs){
	    		char[] c = str.toCharArray();
	    		Arrays.sort(c);
	    		String key = new String(c);
	    		
	    		//map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
	    		if(map.containsKey(key)){
	    			map.get(key).add(str);
	    		}else{
	    			List<String> list = new ArrayList<>();
	    			list.add(str);
	    			map.put(key, list);
	    		}
	    	}
	    	
	    	return new ArrayList(map.values());
	    }

}
