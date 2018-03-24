package com.yahoo.util;

public class KthLargestElementinanArray {
	public static void main(String args[]) {
		int []input = {2,1};
		int k = 1;
		System.out.println(findKthLargest(input, k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }
        return largest(nums, (nums.length - k), 0, nums.length-1);
    }
    
    private static int largest(int[] nums, int k, int start, int end) {
        if (start <= end) {
            int pivot = partition(nums, start, end);
            if (pivot == k) {
                return nums[pivot];
            } else if (pivot > k) {
                return largest(nums, k, start, pivot -1);
            } else {
                return largest(nums, k, pivot +1, end);
            }
        }
        return -1;
    }
    
    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i = i + 1;
            }
        }
        swap(nums, i, end);
        return i;
    }
    
    private static void swap(int nums[],  int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
