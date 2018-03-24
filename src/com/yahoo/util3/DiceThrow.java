package com.yahoo.util3;

public class DiceThrow {
	public static void main(String args[]) {
		int data1 [] = {6, 3, 12}; // 25 
		int data2 [] = {10, 8, 25}; // 318648
		System.out.println(compute(6, 3, 12));
		System.out.println(compute(10, 8, 25));
	}
	
	private static long compute(int m,int n, int x) {
	    // m face, n throws and sum x
	    long dp[][] = new long[n+1][x+1];
	    for (int i = 1; i <= m; i++) {
	        if (i <= x) {
	            dp[1][i] = 1;
	        }
	    }
	    
	    for (int i = 2; i < dp.length; i++) {
	        for (int j = 1; j < dp[0].length; j++) {
	            for (int k = 1; k <= m; k++) {
	                if (k < j) {
	                    dp[i][j] += dp[i-1][j-k];
	                }
	            }
	        }
	        
	    }
	    return dp[n][x];
	}
}
