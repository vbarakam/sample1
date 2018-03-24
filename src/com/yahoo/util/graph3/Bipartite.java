package com.yahoo.util.graph3;

import java.util.Arrays;
import java.util.*;

public class Bipartite {

	public boolean isBipartite(int[][] grid, int start) {
		int color[] = new int[grid.length];
		Arrays.fill(color, -1);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		color[start] = 1;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			for (int edge : grid[vertex]) {
				if (grid[vertex][edge] == 1 && color[edge] == -1) {
					color[edge] = 1 - color[vertex];
					queue.add(edge);
				} else if (grid[vertex][edge] == 1 && color[edge] == color[vertex]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String args[]) {
		int G[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
		Bipartite graph = new Bipartite();
		if (graph.isBipartite(G, 0))
			System.out.println("Yes");
		else
			System.out.println("No");
		// Expected : yes
	}
}
