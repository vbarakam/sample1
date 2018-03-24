package com.yahoo.util.strings;

import java.util.*;

public class PermutationSequence {

	public static void main(String args[]) {
		// System.out.println(getPermutation(8, 8590));
		System.out.println(getPermutation(3, 5));
	}

	public static int factorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public static String getPermutation(int n, int k) {

		// generate array of number
		int[] nums = new int[n];
		int[] counts = new int[n];
		int i = 1;
		for (int index = 0; index < n; index++) {
			nums[index] = i++;
			counts[index] = 1;
		}

		int temp[] = new int[n];
		List<Integer> results = new ArrayList<>();
		permutation4(nums, counts, temp, 0, n, results, k - 1);

		System.out.println(results);
		StringBuilder builder = new StringBuilder();

		return builder.toString();
	}

	public static void permutation4(int ns[], int cs[], int per[], int level, int max, List<Integer> results,
			int k) {
		if (level == max) {
			return;
		}

		int n = max - level;
		int f = factorial(n);
	
		int m = f/n;
		int start = k / m;
		int dd = k % m;
		
		int d = getDigit(ns, cs, start);
		results.add(d);

		permutation4(ns, cs, per, level + 1, max, results, dd);
	}
	
	public static int getDigit(int ns[], int cs[], int start) {
		int activeCount = -1;
		for (int index = 0; index < ns.length; index++) {
			if (cs[index] == 1) {
				activeCount++;
			}
			
			if (activeCount == start) {
				cs[index] = 0;
				return ns[index];
			}
		}
 		return -1; 
	}

	public static void permutation(int ns[], int cs[], int per[], int level, int max, List<List<Integer>> results,
			int k, boolean first) {
		if (level == max) {
			List<Integer> result = new ArrayList<>();
			for (int l : per) {
				result.add(l);
			}
			results.add(result);
			return;
		}

		int fact = 1;
		for (int i = 1; i <= (max - level); i++) {
			fact = fact * i;
		}

		int m = fact / (max - level);
		int start = (k) / m;
		int dd = ((k) % m);

		for (int i = (first ? start : 0); i < (first ? start + 1 : ns.length); i++) {
			if (cs[i] > 0) {
				per[level] = ns[i];
				cs[i] -= 1;
				permutation(ns, cs, per, level + 1, max, results, dd, false);
				cs[i] += 1;
				if (level + 1 != max) {
					break;
				}
			}
		}
	}

	public void permutation2(int ns[], int cs[], int per[], int level, int max, List<List<Integer>> results,
			boolean first, int start) {
		if (level == max) {
			List<Integer> result = new ArrayList<>();
			for (int l : per) {
				result.add(l);
			}
			results.add(result);
			return;
		}

		for (int i = (first ? start : 0); i < (first ? start + 1 : ns.length); i++) {
			if (cs[i] > 0) {
				per[level] = ns[i];
				cs[i] -= 1;
				permutation2(ns, cs, per, level + 1, max, results, false, start);
				cs[i] += 1;

			}
		}
	}
}
