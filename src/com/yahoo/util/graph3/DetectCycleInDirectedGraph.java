package com.yahoo.util.graph3;

import java.util.*;

public class DetectCycleInDirectedGraph {
	private int v;
	private LinkedList<Integer> edges[];
	
	public DetectCycleInDirectedGraph(int v) {
		this.v = v;
		edges = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		edges[u].add(v);
	}
	

	public boolean isCyclic() {
		boolean visited[] = new boolean[v];
		for (int i = 0; i< v; i++) {
			if (dfs(i, visited)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dfs(int vertex, boolean [] visited) {
		if (visited[vertex]) {
			return true;
		} else {
			visited[vertex] = true;
		}
		
		for (int edge : edges[vertex]) {
			if (dfs(edge, visited)) {
				return true;
			}
		}
		visited[vertex] = false;
		return false;
	}

	public static void main(String args[]) {
		DetectCycleInDirectedGraph g = new DetectCycleInDirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		if (g.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}
