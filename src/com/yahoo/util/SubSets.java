package com.yahoo.util;

import java.util.*;

public class SubSets {
	static int [] s = {4,4,4,1,4};

	public static void main(String args[]) {
		int n = s.length;
		Set<List<Integer>> results = new HashSet<>();
		for (int i = 0; i < (1 << n); i++) {
			results.add(binary(s, i, s.length));
		}
		System.out.println(results);
	}
	
	public static List<Integer> binary(int [] nums, int number, int size) {
		int a[] = new int[size];
		int n = size -1;
		while (number > 0) {
			a[n--] = number % 2 ;
			number = number / 2;
		}
		List<Integer> sb = new ArrayList<>();
		for (int index = 0; index < a.length; index++) {
			if (a[index] == 1) {
				sb.add(nums[index]);
			}
		}
		return sb;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				List<Integer> ll = listl(nums, j, i);
				if (ll != null)
					results.add(ll);
			}
		}
		return results;
	}

	public static List<Integer> listl(int[] nums, int start, int level) {
		List<Integer> result = new ArrayList<>();
		for (int j = start; j <= level && j < nums.length; j++) {
			result.add(nums[j]);
		}
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	public static void subsets(char[] chs, int[] cs, int start, int level, char[] temp, int pos) {
		if (level == temp.length) {
			return;
		}

		for (int i = start; i < chs.length; i++) {
			if (cs[i] > 0) {
				// decrease by 1
				cs[i] -= 1;

				temp[level] = chs[i];
				print(temp, level);

				// subsets
				subsets(chs, cs, start + 1, level + 1, temp, pos);

				// increment by 1
				cs[i] += 1;
				// temp[level] = 0;
			}
		}
	}

	public static void print(char[] temp, int level) {
		for (int i = 0; i <= level; i++) {
			System.out.print(temp[i]);
		}
		System.out.println();
	}

}
