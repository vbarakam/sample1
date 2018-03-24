package com.yahoo.util;

import java.util.*;

public class TopKFrequentElements {

	public static void main(String [] args) {
		int data [] = {1};
		topKFrequent(data, 1);
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0));
        }
        List<Integer> buckets [] = new List[nums.length+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); 
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        List<Integer> results = new ArrayList<>();
        int n = 0;
        for (int i = nums.length-1; i >=0 && n < k;i--) {
            if (buckets[i].size() >0) {
                results.addAll(buckets[i]);
                n++;
            }
        }
        return results;
    }
}
