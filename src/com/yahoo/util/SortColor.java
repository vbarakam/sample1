package com.yahoo.util;

import java.util.Arrays;

public class SortColor {
	public static void main(String args[]) {
		Interval[] intervals = new Interval[3];
		// [[9,10],[4,9],[4,17]]
		intervals[0] = new Interval(9, 10);
		intervals[1] = new Interval(4, 9);
		intervals[2] = new Interval(4, 17);
		Arrays.sort(intervals, (first, second) -> Integer.compare(first.start, second.start));

		System.out.println(intervals[0].start + ":" + intervals[0].end);
		System.out.println(intervals[1].start + ":" + intervals[1].end);
		System.out.println(intervals[2].start + ":" + intervals[2].end);

		int[] q = { 1, 0 };
		sort(q, 0, q.length - 1);
		System.out.println(q);
	}

	public static void sort(int[] nums, int start, int end) {
		if (start < end) {
			int index = partition(nums, start, end);
			sort(nums, start, index - 1);
			sort(nums, index + 1, end);
		}
	}

	public static int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int j = start;
		for (int i = start; i < end; i++) {
			if (nums[i] < pivot) {
				// swap
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
		nums[end] = nums[j];
		nums[j] = pivot;
		return j;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
