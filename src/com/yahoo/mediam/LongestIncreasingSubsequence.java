package com.yahoo.mediam;

import java.util.*;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		int data[] = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(data));
	}
	
	public static int lengthOfLIS(int[] nums) {
        int cache [] = new int[nums.length];
        Arrays.fill(cache, 1);
        int max = 0;
        //cache[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i -1; j >= 0; j--) {
                if (nums[j] <  nums[i]) {
                    cache[i] = Math.max(cache[i], cache[j]+1);
                    if (cache[i] > max) {
                        max = cache[i];
                    }
                }
            }
        }
        return max;
    }
}
