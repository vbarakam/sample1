package com.yahoo.util.dynamic;

public class MatrixChainMultiplication {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int score = matrix(arr);
		System.out.println(score);
		if (score != 38) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCCESS");
		}
		arr = new int[] { 3, 3, 3 };
		score = matrix(arr);
		System.out.println(score);
		if (score != 27) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCCESS");
		}
	}
	
	private static int matrix(int nums[]) {
		int n = nums.length;
		int dp[][] = new int[n][n];
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i+1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (nums[i] * nums[k] * nums[j]));
				}
			}
		}
		return dp[0][n-1];
	}

	private static int matrix2(int nums[]) {
		int n = nums.length;
		int dp[][] = new int[n][n];
		int q = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 0; i < n-l; i++) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (nums[i] * nums[k] * nums[j]));
					/*q = dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j];
					if (q < dp[i][j]) {
						dp[i][j] = q;
					}*/
				}
			}
		}
		return dp[0][n-1];
	}
}
