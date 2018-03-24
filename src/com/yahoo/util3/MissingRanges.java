package com.yahoo.util3;

import java.util.*;

public class MissingRanges {
	public static void main(String args[]) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int d = -2147483647;
		int data[] = {0, 1, 3, 50, 75}, lower = 0, upper = 99;
		findMissingRanges(data, lower, upper);
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
        	int low = (i == 0) ? lower : nums[i-1] + 1;
        	int high = (i == nums.length) ? upper : nums[i] - 1;
        	addRange(low, high);
        }
        return results;
	}
	
	private static void addRange(int low, int high) {
		System.out.println(low + " <--> " + high);
	}
	
	private boolean dfs(int course, List<Integer> graph[], boolean visited []) {
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        for (int adj : graph[course]) {
            if (!visited[adj] && !dfs(adj, graph, visited)) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}
