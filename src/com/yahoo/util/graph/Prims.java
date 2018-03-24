package com.yahoo.util.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
	private int num;
	private Vertex[] nodes;
	
	public Prims(int n) {
		this.num = n;
		this.nodes = new Vertex[n];
		for (int i = 0; i < n; i++) {
			this.nodes[i] = new Vertex();
		}
	}
	public void addEdge(int nodeA, int nodeB, int cost) {
		this.nodes[nodeA].neighbors.add(new Edge(nodeA, nodeB, cost));
	}
	
	public void mst() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean visited[] = new boolean[this.num];
		visited[0] = true;
		queue.addAll(nodes[0].neighbors);
		int cost = 0;
		List<Integer> results = new ArrayList<>();
		results.add(0);
		while (!queue.isEmpty()) {
			Edge minEdge = queue.poll();
			if (visited[minEdge.sideB]) {
				continue;
			}
			visited[minEdge.sideB] = true;
			cost += minEdge.cost;
			System.out.println( minEdge.sideA + " --> " + minEdge.sideB);
			results.add(minEdge.sideB);
			queue.addAll(nodes[minEdge.sideB].neighbors);
		}
		System.out.println("cost " + cost);
	}
	
	public static void main(String args[]) {
		/* Let us create the following graph
        2    3
     (0)--(1)--(2)
     |    / \   |
     6| 8/   \5 |7
     | /      \ |
     (3)-------(4)
          9          */
		/*
		 * Edge   Weight
		 * 0 - 1    2
		 *1 - 2    3
		 *0 - 3    6
		 *1 - 4    5
		 * */
		Prims graph = new Prims(5);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 0, 2);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 4, 7);
		graph.addEdge(4, 2, 7);
		graph.addEdge(3, 4, 9);
		graph.addEdge(4, 3, 9);
		graph.addEdge(1, 4, 5);
		graph.addEdge(4, 1, 5);
		graph.addEdge(1, 3, 8);
		graph.addEdge(3, 1, 8);
		graph.addEdge(0, 3, 6);
		graph.addEdge(3, 0, 6);
		graph.mst();
		
	}
	
	static class Vertex {
		List<Edge> neighbors;
		
		public Vertex() {
			neighbors = new ArrayList<>();
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int sideA;
		int sideB;
		int cost;
		
		public Edge(int sideA, int other, int cost) {
			this.sideA = sideA;
			this.sideB = other;
			this.cost = cost;
		}
		
		public int compareTo(Edge to) {
			return this.cost - to.cost;
		}
	}
}
