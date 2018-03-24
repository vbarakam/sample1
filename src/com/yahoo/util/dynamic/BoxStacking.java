package com.yahoo.util.dynamic;

import java.util.Arrays;

public class BoxStacking {

	public static void main(String args[]) {
		// 4 6 7 1 2 3 4 5 6 10 12 32 : 60
		int data1[][] = { { 4, 6, 7 }, { 1, 2, 3 }, { 4, 5, 6 }, { 10, 12, 32 } };
		int val = maxBoxHeight(data1);
		if (val != 60) {
			System.out.println("ERROR");
		} else {
			System.out.println("Sucess");
		}
		// 1 2 3 4 5 6 3 4 1 : 15
		int data2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 3, 4, 1 } };
		System.out.println(maxBoxHeight(data2));

	}

	private static int maxBoxHeight(int[][] data) {
		int dp[][] = new int[3*data.length][data.length];
		int index = 0;
		for (int[] box : data) {
			dp[index++] = new int []{box[0], Math.max(box[1], box[2]), Math.min(box[1], box[2])};
			dp[index++] = new int []{box[1], Math.max(box[0], box[2]), Math.min(box[0], box[2])}; 
			dp[index++] = new int []{box[2], Math.max(box[1], box[0]), Math.min(box[1], box[0])}; 
		}
		Arrays.sort(dp, (a,b)->b[1]*b[2]-a[1]*a[2]);
		int heights[] = new int[dp.length];
		index = 0;
		for (int[] box : dp) {
			heights[index++] = box[0];
		}
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j][1] > dp[i][1] && dp[j][2] > dp[i][2]) {
					heights[i] = Math.max(heights[i], heights[j]+dp[i][0]);
				}
			}
			max = Math.max(max, heights[i]);
		}
		
		return max;
	}
	
	// height width and length
	private static int maxBoxHeight1(int[][] data) {
		int dp[][] = new int[3*data.length][data.length];
		int i = 0;
		// h, l, w
		for (int row [] : data) {
			dp[i++] = new int[]{row[0], Math.max(row[1], row[2]), Math.min(row[2], row[1])};
			dp[i++] = new int[]{row[1], Math.max(row[0], row[2]), Math.min(row[0], row[2])};
			dp[i++] = new int[]{row[2], Math.max(row[1], row[0]), Math.min(row[1], row[0])};
		}
		// sort by area
		Arrays.sort(dp, (a,b)->b[1]*b[2]-a[1]*a[2]);
		
		// create cost and results array
		int heights[] = new int[3*data.length];
		int results[] = new int[3*data.length];
		for (int j = 0; j < dp.length; j++) {
			heights[j] = dp[j][0];
		}
		
		for (int j = 1; j < dp.length; j++) {
			for (int k = 0; k < j; k++) {
				if (dp[k][1] > dp[j][1] && dp[k][2] > dp[j][2]) {
					if (heights[k] + dp[j][0] > heights[j]) {
						heights[j] =  heights[k] + dp[j][0];
						results[j] = k;
					}
				}
			}
		}
		return heights[heights.length-1];
	}
}
