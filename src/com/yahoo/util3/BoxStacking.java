package com.yahoo.util3;

import java.util.Arrays;

public class BoxStacking {

	public static void main(String args[]) {
		// 4 6 7 1 2 3 4 5 6 10 12 32 : 60
		int data1[][] = { { 4, 6, 7 }, { 1, 2, 3 }, { 4, 5, 6 }, { 10, 12, 32 } };
		System.out.println(maxBoxHeight(data1));
		// 1 2 3 4 5 6 3 4 1 : 15
		int data2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 3, 4, 1 } };
		System.out.println(maxBoxHeight(data2));

	}

	// height width and length
	private static int maxBoxHeight(int[][] data) {
}
