package com.yahoo.util.graph3;

import java.util.*;

public class TopologicalSort {
	private int vertex; // number of nodes in the Graph
	private LinkedList<Integer> adj[];

	public TopologicalSort(int v) {
		this.vertex = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[vertex];
		for (int i = 0; i < vertex; i++) {
			if (!visited[i]) {
				tsort(i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private void tsort(int vertex, boolean visited[], Stack<Integer> stack) {
		visited[vertex] = true;
		for (int edge : adj[vertex]) {
			if (!visited[edge]) {
				tsort(edge, visited, stack);
			}
		}
		stack.push(vertex);
	}

	public static void main(String args[]) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}
}
