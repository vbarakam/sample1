package com.yahoo.util2;

import java.util.*;

public class QueueReconstructionbyHeight {
	public static void main(String args[]) {
		int data[][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(data);
		Arrays.sort(data, (a, b)-> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return b[0] - a[0];
			}
		});
		
		int n = data.length;
        List<int[]> tmp = new LinkedList<>();
        for (int i = 0; i < n; i++)
            tmp.add(data[i][1], new int[]{data[i][0], data[i][1]});
		
		System.out.println(data);
		ArrayList<int[]> cache = new ArrayList<>(data.length);
		for (int d[] : data) {
			cache.add(d[1], d);
		}
		cache.toArray(new int[cache.size()][]);
	}
	
	public  static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
