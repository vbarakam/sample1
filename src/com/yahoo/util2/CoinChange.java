package com.yahoo.util2;

import java.util.Arrays;

public class CoinChange {
	public static void main(String args[]) {
		int coins[] = {2};
		int count = 3;
		System.out.println(coinChange2(coins, count));
	}
	
	public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
        	for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    min = Math.min(min, dp[i]);
                }                
            }
        }
        return dp[amount] >= amount ? -1 : min;
    }
	
	public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        long result [] = new long[amount+1];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    result[j] = Math.min(result[j], result[j-coins[i]] + 1);
                }
            }
        }
        
        if (result[amount] >= Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) result[amount];
        }
    }
}
