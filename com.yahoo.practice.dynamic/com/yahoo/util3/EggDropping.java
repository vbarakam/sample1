package com.yahoo.util3;

public class EggDropping {
	public static void main(String args[]) {
		int n = 2, k = 36;
		int val = eggdropping(n, k);
		if (val != 8) {
			System.out.println(val);
			System.out.println("Error");
		} else {
			System.out.println("sucess");
		}
	}
	
	private static int eggdropping(int eggs, int floors) {
		int dp[][] = new int[eggs+1][floors+1];
		for (int i = 1; i <= floors; i++) {
			dp[1][i] = i;
		}
		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				dp[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					dp[e][f] = Math.min(dp[e][f], 1+Math.max(dp[e-1][k-1], dp[e][f-k]));
				}
			}
		}
		return dp[eggs][floors];
	}
}
