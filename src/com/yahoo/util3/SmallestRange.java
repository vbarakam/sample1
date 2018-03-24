package com.yahoo.util3;

import java.util.*;

public class SmallestRange {
	public static void main(String args[]) {
		int data [][] = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
		int result [] = smallestRange(data);
		System.out.println(result[0] + " :: " + result[1]);
	}
	
	public static int[] smallestRange(int[][] nums) {
		int minx = 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int next[] = new int[nums.length];
		PriorityQueue<Integer> queue = new PriorityQueue<>((i,j)->nums[i][next[i]]-nums[j][next[j]]);
		for (int i = 0; i < nums.length; i++) {
			queue.offer(i);
			max = Math.max(max, nums[i][0]);
		}
		boolean flag = true;
		for (int i = 0; i < nums.length && flag; i++) {
			for (int j = 0; j < nums[i].length && flag; j++) {
				int min_i = queue.poll();
				
				if (miny-minx > max - nums[min_i][next[min_i]] ) {
					miny = max;
					minx = nums[min_i][next[min_i]];
				}
				
				next[min_i]++;
				if (next[min_i] == nums[min_i].length) {
					flag = false;
					break;
				}
				
				queue.offer(min_i);
				max = Math.max(max, nums[min_i][next[min_i]]);
			}
		}
        return new int [] {minx, miny};
    }
}
