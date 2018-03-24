package com.yahoo.util2;

import java.util.*;

public class LongestConsecutiveSequence {
	public static void main(String args[]) {
		int data2 [] = {100, 4, 200, 1, 3, 2};
		int data [] = {1,2,0,1};
		System.out.println(longestConsecutive(data));
	}
	
	public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLgn = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num -1) != null ? map.get(num -1) : 0;
                int right = map.get(num + 1) != null ? map.get(num +1) : 0;
                
                int sum = left + right + 1;
                maxLgn = Math.max(sum, maxLgn);
                
                map.put(num, maxLgn);
                if (map.containsKey(num -1)) {
                	map.put(num-1, maxLgn);
                }
                if (map.containsKey(num +1)) {
                	map.put(num+1, maxLgn);
                }
            }
        }
        return maxLgn;
    }
}
