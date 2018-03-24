package com.yahoo.util;

public class Test5 {
	public static void main(String args []) {
		int a [] = { 1, 2,3,4,5};
		productExceptSelf(a);
	}
	
	public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        
        // two elements
        if (nums.length == 2) {
            //[1,0]
             int results[] = new int[nums.length];
             int temp = nums[0];
             results[0] = nums[1];
             results[1] = temp;
            return results;
        }
        
        int results[] = new int[nums.length];
        results[0] = 1;
        //[1,2,3,4]
        // 1, a[0], a[0]*a[1], 
        for (int index = 1; index < nums.length; index++) {
            results[index] = results[index-1] * nums[index-1];
        }
        
        int results2[] = new int[nums.length];
        results2[nums.length -1] = 1;
        for (int index = (nums.length-2); index >= 0; index--) {
            results2[index] = results2[index+1] * nums[index+1];
        }
        
        for (int index = 0; index < nums.length; index++) {
            results[index] = results[index] * results2[index];
        }
        
        return results;
    }
}
