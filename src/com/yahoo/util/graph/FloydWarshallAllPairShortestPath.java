package com.yahoo.util.graph;

import java.util.Deque;
import java.util.LinkedList;

public class FloydWarshallAllPairShortestPath {
	private static final int INF = 1000000;

	public int[][] allPairShortestPath(int[][] graph) {
		int[][] distance = new int[graph.length][graph[0].length];
		int[][] path = new int[graph.length][graph[0].length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				distance[i][j] = graph[i][j];
				if (graph[i][j] != INF && i != j) {
					path[i][j] = i;
				} else {
					path[i][j] = -1;
				}
			}
		}

		for (int k = 0; k < graph[0].length; k++) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					if (distance[i][k] == INF || distance[k][j] == INF) {
						continue;
					}

					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}

		for (int i = 0; i < graph.length; i++) {
			if (distance[i][i] < 0) {
				System.out.println("Negative edge cycle");
			}
		}

		printPath(path, 3, 2);

		return distance;
	}

	public void printPath(int[][] path, int start, int end) {
		if (start < 0 || end < 0 || start >= path.length || end >= path.length) {
			throw new IllegalArgumentException();
		}

		System.out.println("Actual path - between " + start + " " + end);
		Deque<Integer> stack = new LinkedList<>();
		stack.addFirst(end);
		while (true) {
			end = path[start][end];
			if (end == -1) {
				return;
			}
			stack.addFirst(end);
			if (end == start) {
				break;
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pollFirst() + " ");
		}

		System.out.println();
	}

	public static void main(String args[]) {
		int[][] graph = { { 0, 3, 6, 15 }, 
				          { INF, 0, -2, INF }, 
				          { INF, INF, 0, 2 }, { 1, INF, INF, 0 } };

		FloydWarshallAllPairShortestPath shortestPath = new FloydWarshallAllPairShortestPath();
		int[][] distance = shortestPath.allPairShortestPath(graph);
		System.out.println("Minimum Distance matrix");
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance.length; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println("");
		}

	}
}
