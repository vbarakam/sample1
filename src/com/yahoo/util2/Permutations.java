package com.yahoo.util2;

import java.util.*;

public class Permutations {

	public static void main(String args[]) {
		int nums [] = {1,2,3};
		        List<List<Integer>> results = new ArrayList<>();
		        List<Integer> list = new ArrayList<>(Arrays.asList(a));
		        for (int n :  nums) {
		        	list.add(n);
		        }
		        perm(new ArrayList<Integer>(), list, results);
		        System.out.println(results);
		   
	}
	private static void perm(List<Integer> sofar, List<Integer> rest, List<List<Integer>> results) {
        if (rest.size() == 0) {
            results.add(new ArrayList<Integer>(sofar));
            return;
        }
        
        for (int i = 0; i < rest.size(); i++) {
            sofar.add(rest.get(i));
            List<Integer> remain = new ArrayList<>(rest);
            remain.remove(i);
            perm(sofar, remain, results);
            sofar.remove(rest.get(i));
        }
    }
}
