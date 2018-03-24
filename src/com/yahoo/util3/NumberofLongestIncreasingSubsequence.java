package com.yahoo.util3;

import java.util.*;
import java.util.stream.Collectors;

public class NumberofLongestIncreasingSubsequence {
	public static void main(String args[]) {
		int nums[] = { 2, 2, 2, 2, 2 };
		List<List<String>> accounts = null;
		accounts.strList<String, List<String>> group = accounts.stream().collect(Collectors.groupingBy(list->list.get(0)));
		Collections.sort(accounts, (a,b)->a.get(0).compareTo(b.get(0)));
		System.out.println(findNumberOfLIS(nums));
	}

	public static int findNumberOfLIS(int[] nums) {
		int lengths[] = new int[nums.length];
		int counts[] = new int[nums.length];
		Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

		counts[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					if (lengths[j] >= lengths[i]) {
						lengths[i] = lengths[j] + 1;
						counts[i] = counts[j];
					} else if (lengths[j] + 1 == lengths[i]) {
						counts[i] += counts[j];
					}
					/*
					 * if (dp[i] == dp[j] + 1) { counts[i] += counts[j]; } else
					 * { counts[i] = counts[j];
					 * 
					 * }
					 */
				}
			}
		}
		int max = 0;
		for (int num : lengths) {
			max = Math.max(max, num);
		}
		int cnt = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (lengths[i] == max) {
				cnt += counts[i];
			}
		}
		return cnt;
	}
}
