package com.yahoo.util2;

import java.util.*;

public class IntersectionofTwoArraysII {
	public static void main(String args[]) {
		int nums1 []  = {1, 2};
		int nums2 []  =	{1,1};
		intersect(nums1, nums2);
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<Integer>();
        int [] small = nums1.length < nums2.length? nums1 : nums2;
        int [] large = small != nums1 ? nums1 : nums2;
        for (int i = 0; i < small.length; i++) {
            for (int j = 0; j < large.length; j++) {
                if (large[j] != -1001 && small[i] == large[j]) {
                    result.add(small[i]);
                    large[j] = -1001;
                    break;
                }
            }
        }
        
        int [] data = new int[result.size()];
        int i = 0;
        for (int num : result) {
            data[i++] = num;
        }
        
        return data;
    }
}
