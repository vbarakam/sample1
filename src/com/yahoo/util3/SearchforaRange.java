package com.yahoo.util3;

public class SearchforaRange {
	public static void main(String argsp[]) {
		int nums[] = { 5, 7, 7, 8, 8, 10 };
		searchRange(nums, 8);
	}

	public static int[] searchRange(int[] nums, int target) {
		int range1 = binarySearch(nums, target);
		System.out.println(range1);
		if (range1 == nums.length || nums[range1] != target) {
			return new int[] { -1, -1 };
		} else {
			return new int[] { range1, search(nums, target + 1, 0, nums.length) - 1 };
		}
	}

	private static int binarySearch(int[] nums, int target) {
		int start = 0, end = nums.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

	private static int search(int[] nums, int target, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}
