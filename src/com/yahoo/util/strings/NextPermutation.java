package com.yahoo.util.strings;

import java.util.*;

public class NextPermutation {

	public static void main(String args[]) {
		int n[] = { 3, 2, 1 };
		nextPermutation(n);
		for (int n1 : n)
			System.out.println(n1);
	}

	public static void nextPermutation(int[] nums) {
		//
		int originalNumber = arrayToNumber(nums);
		
		int s = 2;
		List<Integer> results = null;
		for (int index = nums.length - 2; index >= 0; index--) {

			// get the last few and add to list
			int cs[] = new int[s];
			int index2 = 0;
			for (int j = nums.length - 1; j >= index; j--) {
				cs[index2++] = nums[j];
			}
			Arrays.sort(cs);
			int ns[] = new int[s];
			int temp[] = new int[s];

			int baseNumber = 0;
			for (int k = 0; k < nums.length; k++) {
				baseNumber = baseNumber * 10 + (k < index ? nums[k] : 0);
			}

			results = new ArrayList<>();
			permutation(cs, ns, temp, 0, results);
			for (int pNumer : results) {
				int fn = baseNumber + pNumer;
				System.out.println(fn);
				if (fn > originalNumber) {
					// update the number
					int l = nums.length -1;
					while (pNumer != 0) {
						nums[l--] = pNumer % 10;
						pNumer = pNumer / 10;
					}
					return;
				}
			}
			// if results contains number > nums, return else continue
			s++;
		}
		
		int pNumer = results.get(0);
		int l = nums.length -1;
		while (pNumer != 0) {
			nums[l--] = pNumer % 10;
			pNumer = pNumer / 10;
		}
	}

	public static void permutation(int cs[], int ns[], int temp[], int level, List<Integer> results) {
		// exist criteria, current number of greater that nums number
		if (cs.length - level == 0) {
			// check the number, if greater return,
			StringBuilder builder = new StringBuilder();
			for (int n : temp) {
				builder.append(n);
			}
			results.add(new Integer(builder.toString()));
			return;
		}

		for (int i = 0; i < cs.length; i++) {
			if (ns[i] == 0) {
				ns[i] = 1;
				temp[level] = cs[i];
				permutation(cs, ns, temp, level + 1, results);
				ns[i] = 0;
			}
		}
	}

	public static int arrayToNumber(int[] nums) {
		StringBuilder builder = new StringBuilder();
		for (int n : nums) {
			builder.append(n);
		}
		return (new Integer(builder.toString()));
	}

	public static int arrayToNumber(List<Integer> nums) {
		StringBuilder builder = new StringBuilder();
		for (int n : nums) {
			builder.append(n);
		}
		return (new Integer(builder.toString()));
	}
}
