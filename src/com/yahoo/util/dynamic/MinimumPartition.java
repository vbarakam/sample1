package com.yahoo.util.dynamic;

public class MinimumPartition {
	public static void main(String args[]) {
		 int arr[] = {1, 6, 11, 5};
		 System.out.println(partition1(arr));
		 System.out.println(partition(arr));
	}
	
	private static int partition(int nums[]) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return minFind(nums, sum, 0, nums.length);
	}
	
	private static int minFind(int nums[], int sum, int firstSum, int index) {
		if (index == 0) {
			return Math.abs(sum-firstSum - firstSum);
		}
		return Math.min(minFind(nums, sum, firstSum+nums[index-1], index-1), 
				minFind(nums, sum, firstSum, index-1));
	}
	
	private static int partition1(int nums[]) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		boolean dp[][] = new boolean[nums.length+1][sum+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i< dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j];
				if (j-nums[i-1] >= 0) {
					dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
				}
			}
		}
		int diff = 0;
		for (int i = sum/2; i >= 0; i--) {
			if (dp[nums.length][i]) {
				diff = sum - i*2;
				break;
			}
		}
		return diff;
	}
}
