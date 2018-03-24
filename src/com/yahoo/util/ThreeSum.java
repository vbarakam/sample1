package com.yahoo.util;

import java.util.*;

public class ThreeSum {
	public static void main(String args[]) {
		int []S = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(S));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<String> c = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            System.out.println(" nums[j] + nums[k] " + (nums[j] + nums[k]));
            System.out.println(" nums[k-1] + nums[k] " + (nums[k-1] + nums[k]));
            if (!(j < k && (nums[j] + nums[k]) < target && (nums[k-1] + nums[k] > target))) {
                continue;
            }
            
            while (j < k) {

                if (nums[j] + nums[k] == target) {
                    List<Integer> ddd = Arrays.asList(nums[i], nums[j], nums[k]);
                    if (!c.contains(ddd.toString())) {
                        results.add(ddd);
                        c.add(ddd.toString());
                    }
                    j++;
                    k--;
                } else if ((nums[j] + nums[k]) > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
		return results;
    }
}
