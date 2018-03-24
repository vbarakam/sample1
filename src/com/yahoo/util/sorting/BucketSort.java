package com.yahoo.util.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
	public static void main(String args[]) {
		double nums[] = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, .21, .12, .23, .68};
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void sort(double nums[]) {
		int n = nums.length;
		List<Double> buckets[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			buckets[i] = new ArrayList<>();
		}
		for (double num : nums) {
			buckets[(int)num*n].add(num);
		}
		System.out.println(buckets);
	}
}
