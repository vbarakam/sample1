package com.yahoo.util.dynamic;

public class WaystoCoveraDistance {
	public static void main(String args[]) {
		int val = coverDistance(3);
		if (val != 4) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESS");
		}
		val = coverDistance(4);
		if (val != 7) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESS");
		}
	}
	
	private static int coverDistance(int n) {
		int dp[] = new int[n+1];
		if (n == 1) {
			return 1;
		} 
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[n];
	}
}
