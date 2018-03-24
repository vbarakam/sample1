package com.yahoo.util2;

import java.util.*;

public class TheSkylineProblem {
	public static void main(String args[]) {
		int [][] data =  {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(data));
	}
	
	public static List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((first, second)-> (first[0] == second[0]) ? first[1] - second[1]: first[0] - second[0]);
        
        // add all the elements to queue
        for (int[] data : buildings) {
            queue.add(new int[]{data[0], -data[2]});
            queue.add(new int[]{data[1], data[2]});
        }
        
        PriorityQueue<Integer> height = new PriorityQueue<>((first, second)->second-first);
        List<int[]> results = new ArrayList<>();
        int prev = 0;
        height.add(0);
        while (!queue.isEmpty()) {
            int [] temp = queue.poll();

            if (temp[1] < 0) {
                height.add(-temp[1]);
            } else {
                height.remove(temp[1]);
            }
            
            int temp2 = height.peek();
            if (prev != temp2) {
                results.add(new int[]{temp[0], temp2});
                prev = temp2;
            }
        }
        return results;
    }
}
