package com.yahoo.util.dynamic;

public class RodCutting {
	public static void main(String args[]) {
	    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	    int val = rodCutting(arr, arr.length);
	    if (val != 22) {
	    	System.out.println("ERROR");
	    } else {
	    	System.out.println("SUCESS");
	    }
	}
	
	private static int rodCutting(int nums[], int n) {
		int dp[][] = new int[nums.length + 1][n+1];
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i-1][j];
				if (j-i >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j-i] + nums[i-1]); 
				}
			}
		}
		return dp[nums.length][n];
	}
}
