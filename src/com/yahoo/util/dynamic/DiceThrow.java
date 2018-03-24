package com.yahoo.util.dynamic;

public class DiceThrow {
	public static void main(String args[]) {
		System.out.println(compute2(6, 3, 8));
		System.out.println(compute(6, 3, 8));
	}

	private static int compute(int faces, int times, int sum) {
		int dp[][] = new int[times+1][sum+1];
		for (int i = 1; i <= faces; i++) {
			if (i <= sum) {
				dp[1][i] = 1;
			}
		}
		for (int i = 2; i <= times; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				for (int k = 1; k <= faces; k++) {
					if (k <= j) {
						dp[i][j] += dp[i-1][j-k];
					}
				}
			}
		}
		return dp[times][sum];
	}
	
	private static int compute2(int sides, int times, int sum) {
		int dp[][] = new int[times + 1][sum + 1];
		for (int i = 1; i <= sides; i++) {
			if (i <= sides) 
				dp[1][i] = 1;
		}
		for (int i = 2; i <= times; i++) {
			for (int j = i; j <= sum; j++) {
				for (int k = 1; k <= sides; k++) {
					if (k < j) {
						dp[i][j] += dp[i - 1][j - k];
					}
				}
			}
		}
		return dp[times][sum];
	}
}
