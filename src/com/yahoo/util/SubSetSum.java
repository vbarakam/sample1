package com.yahoo.util;

import java.util.*;

public class SubSetSum {

	public static void main(String args[]) {
		int test[] = { 100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100 };
		System.out.println(canPartition(test));
	}

	public static boolean canPartition(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        System.out.println( nums.length);
        System.out.println(1 << nums.length);
        for (int i = 1; i < (1 << nums.length); i++) {
            int subSetA [] = numArray(i, nums.length);
            int subSetB [] = complimentNumArray(subSetA);
            
            int ssSumA = subSetSum(nums, subSetA);
            int ssSumB = subSetSum(nums, subSetB);
           // System.out.println( i + " :: " + ssSumA + " :: " + ssSumB);
            if (ssSumA == ssSumB) {
                return true;
            }
        }
        return false;
    }

	public static boolean canPartition3(int[] nums) {

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < (1 << nums.length); i++) {
			int subSetA[] = numArray(i, nums.length);
			int ssSumA = subSetSum(nums, subSetA);
			List<Integer> subSums = getSubSetSums(nums, subSetA);
			if (subSums.contains(ssSumA)) {
				return true;
			}
		}
		return false;
	}

	public static List<Integer> getSubSetSums(int nums[], int flags[]) {
		// find the number of element not in first subset
		int c = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i] == 0) {
				c++;
			}
		}

		// build a nums array based on remaining elemnts
		int nums1[] = new int[c];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (flags[i] == 0) {
				nums1[j++] = nums[i];
			}
		}

		// calculate all the subset sums
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < (1 << nums1.length); i++) {
			int subSetA[] = numArray(i, nums1.length);
			int ssSumA = subSetSum(nums1, subSetA);
			result.add(ssSumA);
		}

		return result;
	}

	public static int subSetSum(int[] nums, int subSetA[]) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (subSetA[i] == 1) {
				sum += nums[i];
			}
		}
		return sum;
	}

	public static int[] numArray(int i, int s) {
		int[] result = new int[s];
		s = s - 1;
		while (i > 0) {
			result[s--] = i % 2;
			i = i / 2;
		}

		return result;
	}

	public static int[] complimentNumArray(int set1[]) {
		int[] result = new int[set1.length];
		for (int i = 0; i < set1.length; i++) {
			if (set1[i] == 0) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
}
