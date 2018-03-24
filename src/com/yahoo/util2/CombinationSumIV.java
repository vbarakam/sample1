package com.yahoo.util2;

public class CombinationSumIV {
	public static void main(String args[]) {
		int target = 32;
		int data[] = {4,2,1};
		int dp[] = new int[target+1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (i-data[j] >= 0) {
					dp[i] += dp[i-data[j]];
				}
			}
		}
		System.out.println(dp[target]);
	}
}
