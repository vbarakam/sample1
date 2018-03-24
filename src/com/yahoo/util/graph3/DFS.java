package com.yahoo.util.graph3;

import java.util.*;

public class DFS {
	private int num;
	private LinkedList<Integer> adjs[];

	public DFS(int vertices) {
		num = vertices;
		adjs = new LinkedList[vertices];
		for (int i = 0; i < num; i++) {
			adjs[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int from, int to) {
		adjs[from].add(to);
	}

	public void dfs(int node, boolean visited []) {
		visited[node] = true;
		System.out.println(" Node " + node);
		for (int adj : adjs[node]) {
			if (!visited[adj]) {
				dfs(adj, visited);
			}
		}
	}
	
	public void dfs(int node) {
		boolean visited [] = new boolean[num];
		dfs(node, visited);
	}

	public static void main(String args[]) {
		DFS graph = new DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		graph.dfs(2);
	}
}
