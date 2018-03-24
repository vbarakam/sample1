package com.yahoo.util;

public class WiggleSort {
	public static void main(String args[]) {
		for(int i = 0; i < 10; i++){
			System.out.println(i);
		}
		int data[] = { 1,5,1,1,6,4 };
		int data2 [] = {1,3,2,2,3,1};
		wiggleSort(data2);
		int n = 3;
		int m = 4;
		//System.out.println((n|1));
		//System.out.println(m|1);
	}

	public static void wiggleSort(int[] nums) {
        int median = kthLargest(nums, (nums.length+1)/2, 0, nums.length-1);
        int start = 0, j = 0, end = nums.length-1;
        int n = nums.length;
        
        while (j <= end) {
            if (nums[newIndex(j,n)] > median) {
                swap(nums, newIndex(start++, n), newIndex(j++, n));
            } else if (nums[newIndex(j,n)] < median) {
                swap(nums, newIndex(j, n), newIndex(end--, n));
            } else {
                j++;
            }
        }
        System.out.println(nums);
        
    }
	
	 private static int newIndex(int index, int n) {
		 System.out.println(index + " :: " + (1 + 2*index) % (n | 1));
	        return (1 + 2*index) % (n | 1);
	 }
    
    private static int kthLargest(int[] nums, int k, int start, int end) {
        if (start <= end) {
            int pivot = parition(nums, start, end);
            if (pivot == k) {
                return nums[pivot];
            } else if (k > pivot) {
                return kthLargest(nums, k, pivot+1, end);
            } else {
                return kthLargest(nums, k, start, pivot-1);
            }
        }
        return -1;
    }
    
    private static int parition(int [] nums, int start, int end) {
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
    
    private static void swap(int [] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
