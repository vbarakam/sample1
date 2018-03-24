package com.yahoo.util3;

public class MatrixChainMultiplication {
	public static void main(String args[]) {
		int arr [] = {1, 2, 3, 4, 5};
		int score = matrix(arr);
		System.out.println(score);
		if (score != 38) {
			System.out.println("ERROR");
		}
		arr = new int[]{3, 3, 3};
		score = matrix(arr);
		System.out.println(score);
		if (score != 27) {
			System.out.println("ERROR");
		}
	}
	
	private static int matrix(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n][n];
		int q = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 0; i < n-l; i++) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < dp[i][j]) {
						dp[i][j] = q;
					}
				}
			}
		}
		return dp[0][n-1];
	}
}
