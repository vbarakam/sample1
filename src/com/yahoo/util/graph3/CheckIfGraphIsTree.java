package com.yahoo.util.graph3;

import java.util.*;

public class CheckIfGraphIsTree {
	private int v;
	private LinkedList<Integer> edges[];

	public CheckIfGraphIsTree(int v) {
		this.v = v;
		edges = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		edges[u].add(v);
		edges[v].add(u);
	}

	public boolean isTree() {
		boolean visited[] = new boolean[v];
		if (dfs(0, visited, -1)) {
			return false;
		}
		for (boolean visit : visited) {
			if (!visit) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int vertex, boolean[] visited, int parent) {
		visited[vertex] = true;
		for (int edge : edges[vertex]) {
			if (!visited[edge]) {
				if (dfs(edge, visited, vertex)) {
					return true;
				}
			} else if (parent != edge) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		CheckIfGraphIsTree g1 = new CheckIfGraphIsTree(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isTree())
			System.out.println("Graph is Tree");
		else
			System.out.println("Graph is not Tree");
		CheckIfGraphIsTree g2 = new CheckIfGraphIsTree(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		if (g2.isTree())
			System.out.println("Graph is Tree");
		else
			System.out.println("Graph is not Tree");

		// is a tree
		// not a tree
	}
}
