package LongestCommon_Subseq_DP;

public class RecursiveApproach {

	public static int noOfWays(int index1,int index2,String s1,String s2){
		//Base Case
		if(index1<0 || index2<0) return 0;
		
		//Match 
		if(s1.charAt(index1) == s2.charAt(index2)){
			return 1 + noOfWays(index1-1,index2-1,s1,s2);
		}

		//Not Match
		
		return 0 + Integer.max(noOfWays(index1-1,index2,s1,s2),
				noOfWays(index1,index2-1,s1,s2));
		
	}
	public static int longestCommonSubsequence(String text1, String text2){
		return noOfWays(text1.length()-1,text2.length()-1,text1,text2);
	}
	public static void main(String[] args) {
	
		
		System.out.println("Length of Longest Common subsequence is : "+
				longestCommonSubsequence("abcde","ace"));
		
		System.out.println("Length of Longest Common subsequence is : "+
				longestCommonSubsequence("abc","abc"));
		
		System.out.println("Length of Longest Common subsequence is : "+
				longestCommonSubsequence("abc","def"));
	}
}
