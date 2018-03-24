package com.yahoo.util.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NumberConnectedComponentsUndirectedGraph {
	public static void main(String args[]) {
		int a1[][] = { {1,1,0},{1,1,0},{0,0,1} };
		int a[][] = {{1},{1}};
		System.out.println(findCircleNum(a));
	}

	public static int findCircleNum(int[][] edges) {
		int count = 0;
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (Integer i = 0; i < edges.length; i++) {
			for (Integer j = 0; j < edges[i].length; j++) {
				if (i == j) {
					continue;
				}

				Integer vertex = edges[i][j];
				if (vertex.equals(0)) {
					continue;
				}
				List<Integer> eds = adjList.get(i);
				if (eds == null) {
					eds = new ArrayList<Integer>();
				}
				eds.add(j);
				adjList.put(i, eds);
			}
		}

		System.out.println(adjList);
		
		List<Integer> visited = new ArrayList<Integer>();
		for (Integer ii = 0; ii < edges.length; ii++) {
			if (!visited.contains(ii)) {
				count++;
				visited.add(ii);
				dfsVisit2(ii, adjList, visited);
			}
		}
		return count;
	}

	public static void dfsVisit2(Integer v, Map<Integer, List<Integer>> adjList, List<Integer> visited) {
		List<Integer> edges = adjList.get(v);
		if (edges == null) {
			return;
		}
		for (Integer edge : edges) {
			if (!visited.contains(edge)) {
				visited.add(edge);
				dfsVisit2(edge, adjList, visited);
			}
		}
	}

	public int dfs(int n, int[][] edges) {
		int count = 0;
		Stack<Character> f = new Stack<Character>();
		// convert edges to adjency list
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			Integer vertex = edges[i][0];
			List<Integer> eds = adjList.get(vertex);
			if (eds == null) {
				eds = new ArrayList<Integer>();
			}
			eds.add(edges[i][1]);
			adjList.put(vertex, eds);

			// other side of edge
			Integer vertex2 = edges[i][1];
			List<Integer> eds2 = adjList.get(vertex2);
			if (eds2 == null) {
				eds2 = new ArrayList<Integer>();
			}
			eds2.add(edges[i][0]);
			adjList.put(vertex2, eds2);

		}

		List<Integer> visited = new ArrayList<Integer>();
		for (Integer i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				count++;
				visited.add(i);
				dfsVisit(i, adjList, visited);
			}
		}
		return count;
	}

	public void dfsVisit(Integer v, Map<Integer, List<Integer>> adjList, List<Integer> visited) {
		List<Integer> edges = adjList.get(v);
		if (edges == null) {
			return;
		}
		for (Integer edge : edges) {
			if (!visited.contains(edge)) {
				visited.add(edge);
				dfsVisit(edge, adjList, visited);
			}
		}
	}
}
