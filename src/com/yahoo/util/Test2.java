package com.yahoo.util;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
	public static void main(String argsp[]) {
		int nums[] = { 1, 3, 2 };
		nextPermutation(nums);
	}

	public static void nextPermutation(int[] nums) {
		if (nums.length <= 1) {
			return;
		}

		int n = nums.length - 1;
		int i = 0;
		for (i = n - 1; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}

		if (i >= 0) {
			int j = 0;
			for (j = n; j >= 0; j--) {
				if (nums[j] > nums[i]) {
					swap(nums, i, j);
					break;
				}
			}
		}
		reverse(nums, i + 1, n - 1);

	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		Map<Integer, Integer> counter1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> counter2 = new HashMap<Integer, Integer>();
		for (int a = 0; a < A.length; a++) {
			for (int b = 0; b < B.length; b++) {
				counter1.put(A[a] + B[b], counter1.getOrDefault((int) (A[a] + B[b]), 0) + 1);
				counter2.put(C[a] + D[b], counter2.getOrDefault((int) (C[a] + D[b]), 0) + 1);
			}
		}

		System.out.println(" counter1 " + counter1);
		System.out.println(" counter2 " + counter2);
		Character c = 'a';
		for (int key : counter1.keySet()) {
			Integer value = counter2.get((int) (-1 * key));

			if (value != null) {
				count += counter1.get(key) * counter2.get((int) (-1 * key));
			}
		}
		return count;
	}

	public static String frequencySort(String s) {
		// conver to array
		char carray[] = s.toCharArray();
		// use buckets
		CharWrapper cc[] = new CharWrapper[256];
		Map<Integer, CharWrapper> map = new HashMap<Integer, CharWrapper>();
		for (int i = 0; i < carray.length; i++) {
			CharWrapper wrapper = map.get((int) carray[i]);
			if (wrapper == null) {
				wrapper = new CharWrapper(carray[i]);
				wrapper.setCount(1);
			} else {
				int count = wrapper.getCount() + 1;
				wrapper.setCount(count);
			}
			map.put((int) carray[i], wrapper);
		}

		cc = map.values().toArray(new CharWrapper[map.size()]);
		for (CharWrapper w : cc) {
			if (w != null) {
				System.out.println(((char) w.getValue()) + " ::: " + w.getCount());
			}
		}
		// sort the array based on value
		// sort the array based on value
		for (int i = 1; i < cc.length; i++) {
			CharWrapper temp = cc[i];
			int j = i - 1;
			while (temp != null && j >= 0 && temp.count < cc[j].count) {

				// swap
				cc[j + 1] = cc[j];
				j = j - 1;

			}
			cc[j + 1] = temp;
		}

		for (CharWrapper w : cc) {
			if (w != null) {
				System.out.println(((char) w.getValue()) + " ::: " + w.getCount());
			}
		}

		// build the final string
		StringBuilder sb = new StringBuilder();
		for (int j = cc.length - 1; j >= 0; j--) {
			for (int k = 0; (cc[j] != null && k < cc[j].getCount()); k++) {
				System.out.println(cc[j].getCount());
				char c = (char) cc[j].getValue();
				sb.append(c);
			}
		}
		return sb.toString();
	}

	static class CharWrapper {
		int c;
		int count;

		public CharWrapper(int c) {
			this.c = c;
		}

		public void setCount(int i) {
			this.count = i;
		}

		public int getCount() {
			return this.count;
		}

		public int getValue() {
			return this.c;
		}
	}
}
