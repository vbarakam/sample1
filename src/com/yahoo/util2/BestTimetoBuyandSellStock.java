package com.yahoo.util2;

public class BestTimetoBuyandSellStock {
	public static void main(String args[]) {
		int data[] = {7,1,5,3,6,4};
		maxProfit(data);
	}
	
	public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int cache [] = new int[prices.length];
        cache[0] = 0;
        int maxDiff = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxDiff = Math.max(maxDiff,-prices[i-1]);
            cache[i] = Math.max(cache[i-1], prices[i]+maxDiff);
        }
        return cache[prices.length-1];
    }
}
