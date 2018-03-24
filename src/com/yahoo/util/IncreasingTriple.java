package com.yahoo.util;

public class IncreasingTriple {

	public static void main(String args[]) {
		int []t = {5,1,5,5,2,5,4};
		System.out.println(increasingTriplet(t));
	}
	public static boolean increasingTriplet(int[] nums) {
        int d [] = new int[nums.length];
        d[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                d[i] = 1 + d[i+1];
            } else {
            	d[i] = Math.max(d[i], d[i+1]);
            }
            if (d[i] >= 3) {
                return true;
            }
        }
        
        return false;
    }
}
