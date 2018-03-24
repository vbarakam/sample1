package com.yahoo.util;

public class Rob {

	public static void main(String args[]) {
		int a[] = {2,1,1,2};
		System.out.println(rob(a));
	}
	
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int e = 0;
        int o = 0;
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            if (i % 2 == 0) {
                if (nums.length % 2 == 1 && i != n -1) {
                    e = Math.max(e + nums[i], o);
                } else if (nums.length % 2 == 0) {
                    e = Math.max(e + nums[i], o);
                }
                
            } else {
                //if (nums.length % 2 == 1 && i != n -1) {
                    o = Math.max(e , o + nums[i]);
                //} else if (nums.length % 2 == 0) {
                //    o = Math.max(e , o + nums[i]);
                //}
            }
        }
        
        return Math.max(e, o);
    }
}
