package com.yahoo.util3;

import java.util.Arrays;

public class RotCutting {
	public static void main(String arg[]) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int arr1[] = { 2, 1, 1 };
		int arr2[] = { 5, 3, 2 };
		System.out.println(rodCutting2(arr, arr.length)); // 4
		System.out.println(coinChange(arr1, 4));
		System.out.println(rodCutting(arr2, 5)); // 2
	}
	
	public static int rodCutting2(int[] coins, int amount) {
		int dp[][] = new int[coins.length+1][amount+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j];
				if (j - i >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - i] + coins[i-1]);
				}
			}
		}
		return dp[coins.length][amount];
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	private static int rodCutting(int price[], int n) {
		int dp[] = new int[n + 1];
		for (int i = 1; i < price.length; i++) {
			for (int j = i; j < dp.length; j++) {
				dp[j] = Math.max(dp[j], price[i - 1] + dp[j - i]);
			}
		}
		return dp[n];
	}

	public static int maxValue(int price[]) {
		int max[] = new int[price.length + 1];
		for (int i = 1; i <= price.length; i++) {
			for (int j = i; j <= price.length; j++) {
				max[j] = Math.max(max[j], max[j - i] + price[i - 1]);
			}
		}
		return max[price.length];
	}
}
