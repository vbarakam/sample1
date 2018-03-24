package com.yahoo.util;

import java.util.*;

public class Knapsack {
	
	public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-coins[i-1] >= 0) {
                    dp[i][j] = dp[i][j] + dp[i-1][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
	
	public static void main(String args[]) {
		int num = 5;
		int arr[] = {1,2,5};
		change(num, arr);
	}
	
	public static void main2(String args[]) {
		// items
		List<Item> items = new ArrayList<>();
		Item item = new Item(1,1);
		items.add(item);
		item = new Item(4,3);
		items.add(item);
		item = new Item(5,4);
		items.add(item);
		item = new Item(7,5);
		items.add(item);
		
		// weight
		int wt = 7;
		int m[][] = knapsack(items, wt);
		List<Item> results = new ArrayList<>();
		int r = items.size();
		int c = wt;
		int max = m[r][c];
		while (max != 0) {
			if (m[r][c] == m[r-1][c]) {
				// r item is not included
				r = r - 1;
				// no change in max
			} else {
				r = r - 1;
				Item item2 = items.get(r);
				results.add(item2);
				max = max - item2.val;
				// move to column until val is equal to max
				while (m[r][c] != max) {
					c -= 1;
				}
			}
		}
		
		System.out.println(results);
	}
	
	public static int[][] knapsack(List<Item> items, int weight) {
		int m[][] = new int[items.size() + 1][weight + 1];
		for (int i = 1; i < items.size() + 1; i++) {
			Item item = items.get(i-1);
			for (int w = 1; w < weight + 1; w++) {
				if (item.weight <= w) {
					/*
					 *  Include this item
					 */
					int rWeight = w-item.weight;
					int val = m[i-1][rWeight];
					int max = Math.max(item.val + val, m[i-1][w]);
					m[i][w] = max;
				} else {
					m[i][w] = m[i-1][w];
				}
			}
		}
		
		return m;
	}
	
	static class Item {
		int val;
		int weight;
		
		public Item(int val, int weight) {
			this.val = val;
			this.weight = weight;
		}
		
		public String toString() {
			return " Val : " + val + " Weight : " + weight;
		}
	}
}
