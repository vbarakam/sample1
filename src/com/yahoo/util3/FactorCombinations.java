package com.yahoo.util3;

import java.util.*;

public class FactorCombinations {
	public static void main(String args[]) {
		System.out.println(getFactors(32));
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> results = new ArrayList<>();
		if (isPrime(n)) {
			return results;
		}
		process(n, new ArrayList<Integer>(), results);
		return results;
	}

	private static void process(int n, List<Integer> result, List<List<Integer>> results) {
		if (n <= 2) {
			results.add(new ArrayList<>(result));
			return;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				result.add(i);
				process(n / i, result, results);
				result.remove((Integer) i);
			}
		}
	}

	private static boolean isPrime(int n) {
		int limit = (int) Math.sqrt(n);
		for (int i = 2; i < limit; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
