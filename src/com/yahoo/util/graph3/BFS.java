package com.yahoo.util.graph3;

import java.util.LinkedList;

public class BFS {
	private int num;
	private LinkedList<Integer> adjs [];
	
	public BFS(int n) {
		num = n;
		adjs = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adjs[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int nodeA, int nodeB){
		adjs[nodeA].add(nodeB);
	}
	
	public void bfs(int node) {
		boolean visited [] = new boolean[num];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			System.out.println(" Node " + n);
			for (int adj : adjs[n]) {
				if (!visited[adj]) {
					visited[adj] = true;
					queue.add(adj);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		BFS graph = new BFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.bfs(2);
		//2 0 3 1
	}
}
