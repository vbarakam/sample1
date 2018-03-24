package com.yahoo.util3;

public class WiggleSort2 {
	public static void main(String args[]){
		int data[] = {1,3,2,2,3,1};
		wiggleSort2(data);
		for (int num : data) {
			System.out.print(" " + num );
		}
	}
	
	public static void wiggleSort(int[] nums) {
        int median = kthLargest(nums, (nums.length+1)/2, 0, nums.length-1);
        int start = 0, j = 0, end = nums.length-1, n = nums.length;
        while (j <= end) {
            if (nums[index(j,n)] < median) {
                swap(nums, index(j,n), index(end--,n));
            } else if (nums[index(j,n)] > median) {
                swap(nums, index(start++,n), index(j++,n));
            } else {
                j++;
            }
        }
    }
	
	public static void wiggleSort2(int[] nums) {
        int median = kthLargest(nums, (nums.length+1)/2, 0, nums.length-1);
        int start = 0, j = 0, end = nums.length-1;
        int n = nums.length;
        
        while (j <= end) {
            if (nums[index(j,n)] > median) {
                swap(nums, index(start++, n), index(j++, n));
            } else if (nums[index(j,n)] < median) {
                swap(nums, index(j++, n), index(end--, n));
            } else {
                j++;
            }
        }
        System.out.println(nums);
        
    }
    
    private static int index(int i, int n) {
        return (1 + 2*i) % (n|1);
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
