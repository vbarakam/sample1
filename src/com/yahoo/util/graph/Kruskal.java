package com.yahoo.util.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
	private int num;
	private Node nodes[];
	private List<Edge> edges;
	
	public Kruskal(int size) {
		num = size;
		nodes = new Node[num];
		for (int i = 0; i < num; i++) {
			nodes[i] = new Node(-1);
		}
		edges = new ArrayList<>();
	}
	
	static class Node {
		int key;
		List<Edge> edges;
		
		public Node(int data) {
			key = data;
			edges = new ArrayList<>();
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int nodeA;
		int nodeB;
		int weight;
		
		public Edge(int nodeA, int nodeB, int weight) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight = o.weight;
		}
	}
	
	public void addEdge(int nodeA, int nodeB, int weight) {
		Edge edge = new Edge(nodeA, nodeB, weight);
		nodes[nodeA].edges.add(edge);
		nodes[nodeB].edges.add(edge);
		edges.add(edge);
	}
	
	public int mst() {
		PriorityQueue<Edge> queue = new PriorityQueue<>((a,b)->a.weight-b.weight);
		queue.addAll(edges);
		DisjointSet set = new DisjointSet();
		for (int i = 0; i < num; i++) {
			set.makeSet(i);
		}
		int cost = 0;
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (set.findSet(edge.nodeA) != set.findSet(edge.nodeB)) {
				System.out.println(edge.nodeA +  " --> " + edge.nodeB);
				cost += edge.weight;
				set.union(edge.nodeA, edge.nodeB);
			}
		}
		return cost;
		
	}
	
	public static void main (String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
		
		Kruskal graph = new Kruskal(4);
		graph.addEdge(0, 1, 10);
		graph.addEdge(1, 3, 15);
		graph.addEdge(3, 2, 4);
		graph.addEdge(2, 0, 6);
		graph.addEdge(3, 0, 5);
		System.out.println(graph.mst());
		// 9 
    }
}
