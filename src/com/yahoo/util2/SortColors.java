package com.yahoo.util2;

public class SortColors {
	public static void main(String args[]) {
		//int data[] = { 2, 1, 1, 0 };
		int data[] = {1,0};
		sortColors3(data);
	}

	public static void sortColors3(int[] nums) {
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				start++;
			}
		}

		int end = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 2) {
				end--;
			}
		}

		for (int i = start; i <= end; i++) {
			if (nums[i] == 2) {
				swap(nums, i, end--);
			}

			if (nums[i] == 0 && i > start) {
				swap(nums, i, start++);
			}
		}
	}

	public static void sortColors2(int[] nums) {
		int start = 0, end = nums.length - 1;
		// move to first non zero
		while (start < end && nums[start] == 0) {
			start++;
		}

		// move to last non zero
		while (end > start && nums[end] == 2) {
			end--;
		}
		// [0,1,1,2] start = 1, i=1, end=2
		for (int i = start; i <= end; i++) {
			while (nums[i] == 2 && i < end) {
				swap(nums, i, end--);
			}

			while (nums[i] == 0 && start < end) {
				swap(nums, i, start++);
			}
		}
	}

	public static void sortColors(int[] nums) {
		if (nums.length == 0) {
			return;
		}

		int start = 0;
		int end = nums.length - 1;
		while (end >= 0 && nums[end] == 2) {
			end--;
		}
		while (start < end && nums[start] == 0) {
			start++;
		}
		for (int i = start; i <= end; i++) {
			while (nums[i] == 2 && i < end) {
				swap(nums, i, end--);
			}
			while (nums[i] == 0 && i > start) {
				swap(nums, start++, i);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
