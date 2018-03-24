package com.yahoo.util;

public class FindMinimuminRotatedSortedArray {
	public static void main(String args[]) {
		//int []ii = {2,3,1};
		//int []ii = {2,1};
		int []ii = {1, 2};
		System.out.println(findMin(ii));
	}
	
	public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return binarySearch(nums, 0, nums.length -1);
    }
    
	public static int binarySearch(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end)/2;
            if (nums[end] < nums[start]) {
                return binarySearch(nums, mid+1, end);
            } else if (nums[start] < nums[end]) {
                return binarySearch(nums, start, mid -1);
            }
            return nums[mid];
        }
        return -1;
    }
}
