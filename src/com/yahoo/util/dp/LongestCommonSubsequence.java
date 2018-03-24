package com.yahoo.util.dp;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String str1 = "abcdaf";
		String str2=  "acbcf";
		System.out.println(longestCommonSequence(str1, str2));
	}
	
	private static String longestCommonSequence(String str1, String str2){
	    if (str1.length() == 0 || str2.length() == 0) {
	        return "";
	    }
	    
	    int dp[][] = new int[str1.length()+1][str2.length()+1];
	    int max = 0;
	    for (int i = 1; i <= str1.length(); i++) {
	        for (int j = 1; j <= str2.length(); j++) {
	            if (str1.charAt(i-1) == str2.charAt(j-1)) {
	                dp[i][j] = dp[i-1][j-1] + 1;
	                max = Math.max(max, dp[i][j]);
	                //sb.append(str1.charAt(i-1));
	            } else {
	                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
	            }
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    int j = str2.length();
	    for (int i = str1.length(); i >= 1; ) {
	        for (; j >= 1;) {
	            if (dp[i][j] == dp[i-1][j]) {
	            	i--;
	            	break;
	            } else if (dp[i][j] == dp[i][j-1]) {
	            	j--;
	            } else {
	            	sb.append(str1.charAt(j));
	            	i--;
	            	j--;
	            	break;
	            }
	        }
	    }
	    return sb.reverse().toString();
	}
}
