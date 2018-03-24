package com.yahoo.util3;

public class OptimalStrategyforaGame {
	static class Pair {
		int first;
		int second;
		int pos;
	}

	public static void main(String args[]) {
		int arr1[] = {8, 15, 3, 7};
		Pair moves[][] = optimal(arr1);
		if (moves[0][arr1.length-1].first != 22) {
			System.out.println("Error");
		} else {
			System.out.println("Sucess");
		}
		int arr2[] = {2, 2, 2, 2};
		Pair moves2[][] = optimal(arr2);
		if (moves2[0][arr2.length-1].first != 4) {
			System.out.println("Error");
		} else {
			System.out.println("Sucess");
		}
		int arr3[] = {20, 30, 2, 2, 2, 10};
		Pair moves3[][] = optimal(arr3);
		if (moves3[0][arr3.length-1].first != 42) {
			System.out.println("Error");
		} else {
			System.out.println("Sucess");
		}
	}

	private static Pair[][] optimal(int nums[]) {
		int n = nums.length;
		Pair dp[][] = new Pair[n][n];

		return dp;
	}
}
