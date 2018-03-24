package com.yahoo.util3;

public class MatrixChain {
	public static void main(String args[]) {
		int q = 0;
		int arr[] = { 100, 75, 50, 25 };
		int n = arr.length;
		System.out.println(findCost(arr));

		int temp[][] = new int[arr.length][arr.length];
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = temp[i][k] + temp[k][j] + (arr[i] * arr[k] * arr[j]);

					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
				}
			}
		}

		System.out.println(temp[0][arr.length - 1]);
	}

	private static int matrix(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n][n];
		int d = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					d = dp[i][k] + dp[k][j] + (arr[i] * arr[k] * arr[j]);

					if (d < dp[i][j]) {
						dp[i][j] = d;
					}
				}
			}
		}
		return dp[0][n - 1];
	}

	public static int findCost(int arr[]) {
		int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = temp[i][k] + temp[k][j] + (arr[i] * arr[k] * arr[j]);
					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
				}
			}
		}
		return temp[0][arr.length - 1];
	}
}
