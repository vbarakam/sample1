package com.yahoo.util2;

import java.util.*;

public class MissingRanges {
	public static void main(String args[]) {
		int range [] = {0, 1, 3, 50, 75};
		int lower = 0, upper = 99;
		int d = 2147483647;
		findMissingRanges(range, lower, upper);
	}
	
	 public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        List<String> results = new ArrayList<>();
	        
	        for (int i = 0 ; i <= nums.length; i++) {
	            int l = (i == 0) ? lower : nums[i-1] + 1;
	            int u = (i == nums.length) ? upper : nums[i] -1;
	            addRange(results, l, u);
	        }
	        
	        return results;
	    }
	    
	    private static void addRange(List<String> results, int lower, int upper) {
	        if (lower > upper) {
	            return;
	        } else if (upper == lower) {
	            results.add("" + lower);
	        } else {
	            results.add(lower + "->" + upper);
	        }
	    }
}
