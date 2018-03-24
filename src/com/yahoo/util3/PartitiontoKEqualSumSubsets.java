package com.yahoo.util3;

public class PartitiontoKEqualSumSubsets {
	public static void main(String args[]) {
		int nums [] = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(canPartitionKSubsets(nums, k));
	}
	
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % k > 0) {
            return false;
        }
        sum /= k;
        boolean dp[][] = new boolean [nums.length+1][sum+1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-nums[i-1] >= 0) {
                     dp[i][j] =  dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
