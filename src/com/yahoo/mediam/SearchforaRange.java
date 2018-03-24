package com.yahoo.mediam;

public class SearchforaRange {
	public static void main(String args[]) {
		int data[] = {5,7,7,8,8,10};
		int start = searchRange(data, 2);
		//if (start == (data.length - 1) || args[start] != null) {
			//return new int[] {-1,-1};
		//}
		System.out.println(searchRange(data, 2));
		System.out.println(searchRange(data, 20));
	}
	
	public static int searchRange(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end)/2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}
