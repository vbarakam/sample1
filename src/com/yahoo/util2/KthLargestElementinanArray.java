package com.yahoo.util2;

public class KthLargestElementinanArray {
	public static void main(String args[]) {
		
	}
	
	public static int findKthLargest(int[] nums, int k) {
        return kthLargest(nums, nums.length - k, 0, nums.length-1);
    }
    
    private static int kthLargest(int[] nums, int k, int start, int end) {
        if (start <= end) {
            int pivot = partition(nums, start, end);
            if (k == pivot) {
                return nums[k];
            } else if (pivot > k) {
                return kthLargest(nums, k, start, pivot-1);
            } else {
                return kthLargest(nums, k, pivot+1, end);
            }
        }
        return -1;
    }
    
    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (pivot >= nums[j]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }
    
    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
