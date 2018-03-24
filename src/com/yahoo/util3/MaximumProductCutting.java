package com.yahoo.util3;

public class MaximumProductCutting {
	public static void main(String args[]) {
		System.out.println(maxProd(10));
		System.out.println(maxProd3(10));

		int data[] = new int[10];
		for (int i = 0; i < 10; i++) {
			data[i] = i +1;
		}
		rodCutting2(data, 10);
	}
	
	private static int maxProd(int n) {
		if (n == 0 || n ==1) {
			return 0;
		}
		
		int max = 0;
		for (int i = 1; i < n; i++) {
			max = Math.max(max,Math.max(i*(n-i), maxProd(n-i)*i));
		}
		return max;
	}
	
	public static int rodCutting2(int[] coins, int amount) {
		int dp[][] = new int[coins.length+1][amount+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j];
				if (j - i >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - i] + 1);
				}
			}
		}
		return dp[coins.length][amount];
	}
	
	private static int maxProd3(int n)
	{
	   int val[] = new int[n+1];
	   val[0] = val[1] = 0;
	  
	   for (int i = 1; i <= n; i++)
	   {
	      int max_val = 0;
	      for (int j = 1; j <= i/2; j++) {
	         max_val = Math.max(max_val, Math.max((i-j)*j, j*val[i-j]));
	      }	      
	      val[i] = max_val;
	   }
	   return val[n];
	}
	
	private static int maxProd2(int n) {
		if (n == 0 || n ==1) {
			return 0;
		}
		
		int max = 0;
		for (int i = 1; i < n; i++) {
			max = Math.max(max,Math.max(i*(n-i), maxProd2(n-i)*i));
		}
		return max;
	}
	
}
