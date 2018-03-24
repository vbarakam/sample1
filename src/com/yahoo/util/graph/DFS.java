package com.yahoo.util.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {
	private int vertices = 0;
	private int time = 0;
	private LinkedList<Integer> adjs[];

	public DFS(int v) {
		this.vertices = v;
		adjs = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjs[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjs[v].add(w);
	}

	public void dfs() {
		int color[] = new int[this.vertices];
		int parent[] = new int[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (color[i] == 0) {
				dfsvisit(i, color, parent);
			}
		}
	}

	public void dfsvisit(int start, int color[], int parent[]) {
		time = time+1;

		color[start] = 1;
		System.out.println(start);
		for (int adj : adjs[start]) {
			if (color[adj] == 0) {
				parent[adj] = start;
				dfsvisit(adj, color, parent);
			}
		}
		color[start] = 2;
		time = time+1;
	}

	public static void main(String args[]) {
		DFS g = new DFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.dfs();
	}
}
