package com.yahoo.util3;

import java.util.*;

public class CombinationSum {

	public static void main(String args[]) {
		CombinationSum sum = new CombinationSum();
		int candidates [] = {10, 1, 2, 7, 6, 1, 5};
		System.out.println(sum.combinationSum2(candidates, 8));
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, results, new ArrayList<Integer>(), 0, 0);
        return results;
    }
    
    private void process(int[]candidates, int target, List<List<Integer>> results, 
                         List<Integer> combi, int currentSum, int index) {
        if (currentSum == target) {
            results.add(new ArrayList<Integer>(combi));
            return;
        } else if (currentSum > target) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            combi.add(candidates[i]);
            if ( currentSum+candidates[i] <= target)
            	process(candidates, target, results, combi, currentSum+candidates[i], i+1);
            combi.remove(combi.size()-1);
        }
        
    }
}

