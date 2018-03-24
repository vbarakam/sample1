package com.yahoo.util;

import java.util.*;

public class ContainsDuplicateIII {
	public static void main(String args[]) {
		int []a = {-1,2147483647};
		int k =	1;
		int t = 2147483647;
		containsNearbyAlmostDuplicate(a, k, t);
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeMap<Integer, Integer> cache = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = new Integer(nums[i]);
            // check for index diff
            if (cache.containsKey(num) && Math.abs(cache.get(num) - i) <= k) {
                return true;
            } else {
                Set<Integer> set = cache.descendingKeySet();
                for (Integer nums2 : set) {
                    if (Math.abs(nums2-num) <= t && Math.abs(cache.get(nums2) - i) <= k) {
                        return true;
                    }
                }
            }
            cache.put(num, i);
        }
        return false;
    }
}
