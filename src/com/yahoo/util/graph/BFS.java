package com.yahoo.util.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private int vertices = 0;
	private LinkedList<Integer> adjs[];

	public BFS(int v) {
		this.vertices = v;
		adjs = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjs[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjs[v].add(w);
	}

	public void bfs(int start) {
		int color[] = new int[this.vertices];
		int dist[] = new int[this.vertices];
		int parent[] = new int[this.vertices];
		color[start] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node);
			for (int adj : adjs[node]) {
				if (color[adj] == 0) {
					color[adj] = 1;
					parent[adj] = node;
					dist[adj] = dist[node] + 1;
					queue.add(adj);
				}
			}
			color[node] = 2;
		}
	}

	public static void main(String args[]) {
		BFS g = new BFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.bfs(2);
	}
}
