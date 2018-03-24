package com.yahoo.util2;

public class RotateArray {
	public static void main(String args[]) {
		int data [] = {1,2,3,4,5,6,7};
		rotate(data, 3);
	}
	
	 public static void rotate(int[] nums, int k) {
	        if (nums.length < 2) {
	            return;
	        }
	        
	        reverse(nums, 0, nums.length -1);
	        reverse(nums, k, nums.length -1);
	        reverse(nums, 0, k -1);
	    }
	    
	    private static void reverse(int[] nums, int start, int end) {
	        while (start < end) {
	            int temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	            start++;
	            end--;
	        }
	    }
	
	private static void swap(int[] nums, int k, int j) {
		int temp = nums[k];
		nums[k] = nums[j];
		nums[j] = temp;
	}
}
