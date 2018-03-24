package com.yahoo.util2;

public class ShortestUnsortedContinuousSubarray {
	public static void main(String args[]){
		int data[] = {1,2,3,4};
		System.out.println(findUnsortedSubarray(data));
	}
	
	public static int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                max = Math.max(max, nums[i]);
            }
        }
        int l = 0;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min) {
                break;
            }
        }
        int r = 0;
        for (r = nums.length-1; r >= 0; r--) {
            if (nums[r] < max) {
                break;
            }
        }
        
        return l > r ? 0 : r - l +1;
    }
}
