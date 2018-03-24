package com.yahoo.util3;

import java.util.*;

public class CountofSmallerNumbersAfterSelf {

	public static void main(String args[]) {
		//int data[] = {5,2,6,1};
		//System.out.println(countSmaller(data));
		int data[] = {2,5, 30, 50};
		binarySearch(data, 3);
	}
	
	private static void binarySearch(int nums[], int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left+right)/2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		System.out.println(left + " :: " + right);
	}
	
	
	public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer results[] = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = n -1; i>=0; i--) {
            int index = find(sorted, nums, nums[i]);
            results[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(results);
    }
    
    private static int find(List<Integer> sorted, int[]  nums, int target) {
        if (sorted.size() == 0) {
            return 0;
        }
        
        int left = 0, right = sorted.size() -1;
        if (target <= sorted.get(left)) {
            return 0;
        } else if (target >= sorted.get(right)) {
            return sorted.size();
        }
        
        while (right < left) {
            int mid = (right + left)/2;
            if (sorted.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (sorted.get(left) < target) {
            return left;
        } else {
            return right;
        }
    }
}
