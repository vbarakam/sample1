package com.yahoo.util;

public class MaxSumArray {
	public static void main(String args[]) {
		int sample[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray2(sample));
	}

	public static int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	public static int maxSubArray2(int[] nums) {
		int dp[] = new int[nums.length];
		int max = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0 ) + nums[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
