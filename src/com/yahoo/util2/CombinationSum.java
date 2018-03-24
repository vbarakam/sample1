package com.yahoo.util2;

import java.util.*;

public class CombinationSum {
	public static void main(String args[]){
		int data[] = {4,2,1};
		int target = 32;
		Arrays.sort(data);
		System.out.println(combinationSum(data, target));
	}
	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> results = new ArrayList<>();
	        process(candidates, results, new ArrayList<>(), 0, candidates.length, target, 0);
	        return results;
	    }
	    
	    private static void process(int[] candidates, 
	                         List<List<Integer>> results, 
	                         List<Integer> comb, 
	                         int start, 
	                         int end, 
	                         int target, 
	                         int currentSum) {
	        if (currentSum == target) {
	            results.add(new ArrayList<Integer>(comb));
	            return;
	        } else if (currentSum > target) {
	            return;
	        }
	        
	        for (int i = start; i < end; i++) {
	            comb.add(candidates[i]);
	            process(candidates, results, comb, start, end, target, currentSum+candidates[i]);
	            comb.remove(comb.size()-1);
	        }
	    }
}
