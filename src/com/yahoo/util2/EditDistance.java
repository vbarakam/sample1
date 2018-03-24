package com.yahoo.util2;

public class EditDistance {
	public static void main(String args[]) {
		String str1 = "a";
		String str2 = "b";
		System.out.println(minDistance(str1, str2));
	}
	
	public static int minDistance(String word1, String word2) {
        if ((word1.length() == 0 || word2.length() == 0) && word1.length() > 0 || word2.length() > 0) {
            return Math.abs(word1.length() - word2.length());
        }
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        
        for (int j = 1; j < dp.length; j++) {
            dp[j][0] = j;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <=dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    dp[i][j] =  Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
