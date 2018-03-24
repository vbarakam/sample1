package com.yahoo.util.dynamic;

public class MaximalProductwhenCuttingRope {
	public static void main(String args[]) {
		int val = maxProduct(5);
		if (val != 6) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESS");
		}
		val = maxProduct(10);
		if (val != 36) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESS");
		}
	}
	
	private static int maxProduct(int n) {
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 0;
		for (int i = 1; i <=n; i++) {
			int max_value = 0;
			for (int j = 1; j <= i/2; j++) {
				max_value = Math.max(max_value, Math.max(j*(i-j), j*dp[i-j]));
			}
			dp[i] = max_value;
		}
		return dp[n];
	}

	private static int maxProduct2(int n) {
		int dp[] = new int[n+1];
		dp[0] = dp[1] = 0;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= i/2; j++) {
				max = Math.max(max, Math.max((i-j) * j, dp[i-j] * j));
			}
			dp[i] = max;
		}
		return dp[n];
	}
}
