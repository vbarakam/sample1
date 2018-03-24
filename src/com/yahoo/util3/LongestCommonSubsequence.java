package com.yahoo.util3;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		int score = lcs(str1, str2);
		if (score != 3) {
			System.out.println("Error");
		}
		str1 = "ABC";
		str2 = "AC";
		score = lcs(str1, str2);
		if (score != 2) {
			System.out.println("Error");
		}
	}
	
	private static int lcs(String str1, String str2) {
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++ ) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}
}
