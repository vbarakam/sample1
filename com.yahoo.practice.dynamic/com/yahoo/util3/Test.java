package com.yahoo.util3;

public class Test {
	public static void main(String args[]) {
		int nums [] = {4,6,8,10,12};
		binarySearch(nums, -1);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, -1));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, -1));
		binarySearch(nums, 1);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 1));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 1));
		binarySearch(nums, 100);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 100));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 100));
		binarySearch(nums, 9);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 9));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 9));
		binarySearch(nums, 10);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 10));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 10));
		binarySearch(nums, 12);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 12));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 12));
		binarySearch(nums, 4);
		System.out.println(" option 2  : " + binarySearch(nums, 0, nums.length-1, 4));
		System.out.println(" option 3  : " + binarySearch2(nums, 0, nums.length-1, 4));

	}
	
	private static void binarySearch(int nums[], int target) {
		int start = 0, end = nums.length-1;
		while (start <= end) {
			int mid = (start+end)/2;
			if (nums[mid] == target) {
				System.out.println("found ==> " + mid);
				return;
			} else if (target < nums[mid]) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		System.out.println(start + " ==> " + end);
	}
	
	static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return l;
    }
	
	static int binarySearch2(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            //if (arr[mid] == x)
              // return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return l;
    }

}
