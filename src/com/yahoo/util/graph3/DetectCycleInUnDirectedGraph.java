package com.yahoo.util.graph3;

import java.util.*;

public class DetectCycleInUnDirectedGraph {
	private int v;
	private LinkedList<Integer> edges[];
	
	public DetectCycleInUnDirectedGraph(int v) {
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
	

	public boolean isCyclic() {
		boolean visited[] = new boolean[v];
		for (int i = 0; i< v; i++) {
			if (!visited[i]) {
				if (dfs(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs(int vertex, boolean [] visited, int parent) {
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
		DetectCycleInUnDirectedGraph g1 = new DetectCycleInUnDirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}
