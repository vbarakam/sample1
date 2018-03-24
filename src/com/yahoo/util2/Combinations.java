package com.yahoo.util2;

import java.util.*;

public class Combinations {
	public static void main(String args[]){
		List<List<Integer>> results = new ArrayList<>();
		process(results, new ArrayList<Integer>(), 1,  4-2+1, 2);
		System.out.println(results);
	}
	
	private static void process(List<List<Integer>> results, List<Integer> combinations, int start, int end, int k) {
		if (k == 0) {
			List<Integer> clone = new ArrayList<>();
			clone.addAll(combinations);
			results.add(clone);
			return;
		}
		//if (end-start+1>= k) {
			for (int i = start; i <= end; i++) {
				combinations.add(i);
				process(results, combinations, start+1, end+1, k -1);
				combinations.remove(combinations.size() - 1);
			}
		//}

	}
}
