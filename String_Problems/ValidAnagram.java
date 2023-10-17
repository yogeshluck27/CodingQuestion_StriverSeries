package String_Problems;
//Str1 = ”INTEGER”
//Str2 = ”NTEGERI”

//Approach: Just count the frequency of every element in Str1 and iterate through Str2 and 
//decrease the count of every element in the frequency array. 
//Now iterate again, if the frequency at any point is not 0 this means, strings are not anagrams of each other.
public class ValidAnagram {
	
	public static boolean checkAnagrams(String str1,String str2){
		
		if(str1.length() != str2.length()) return false;
		int[] frequency = new int[26];
		
		for(int i=0 ; i<str1.length(); i++){
			frequency[str1.toLowerCase().charAt(i)-'a']++;
		}
		
		for(int i=0 ; i<str2.length(); i++){
			frequency[str2.toLowerCase().charAt(i)-'a']--;
		}
		
		for(int i=0 ; i< frequency.length; i++){
			if(frequency[i] != 0)
				return false;
		}
		
		return true;
	}
	
	
	 public static void main(String args[]) {
		    String Str1 = "anagram";
		    String Str2 = "nagaram";
		    System.out.println(checkAnagrams(Str1, Str2));
		    
		    
		    String Str3 = "INTEGER";
		    String Str4 = "TEGERNI";
		    System.out.println(checkAnagrams(Str3, Str4));
		  }
}
