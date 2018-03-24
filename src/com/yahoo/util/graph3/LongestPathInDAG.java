package com.yahoo.util.graph3;

import java.util.*;

public class LongestPathInDAG {
	private int v; // number of vertices
	private LinkedList<AdjListNode> adjs[];
	private Map<Integer, Integer> predecessor;

	public LongestPathInDAG(int v) {
		this.v = v;
		adjs = new LinkedList[v];
		predecessor = new HashMap<>();
		for (int i = 0; i < v; i++) {
			adjs[i] = new LinkedList<AdjListNode>();
		}
	}

	public void addEdge(int u, int v, int weight) {
		adjs[u].add(new AdjListNode(v, weight));
	}

	public void longestPath(int v3) {
		Stack<Integer> stack = new Stack<>();
		int d[] = new int[v];
		Arrays.fill(d, Integer.MIN_VALUE);
		d[v3] = 0;
		boolean[] visited = new boolean[v];
		topologicalSort(visited, stack);
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			System.out.println("vertex : " + vertex);
			// System.out.println(d[vertex]);
			if (d[vertex] != Integer.MIN_VALUE) {
				for (AdjListNode adj : adjs[vertex]) {
					// System.out.println(d[vertex]);
					if (adj.v != v3) {
						if (d[adj.v] < d[vertex] + adj.weight) {
							predecessor.put(vertex, adj.v);
							d[adj.v] = d[vertex] + adj.weight;
						}
					}
				}
			}
		}

		for (int dis : d) {
			System.out.println(" " + dis);
		}
	}

	public void printPath(int start) {
		System.out.print(" start-> " + start);
		while (predecessor.get(start) != null) {
			start = predecessor.get(start);
			System.out.print(" -> " + start);
		}
	}

	public void topologicalSort(boolean[] visited, Stack<Integer> stack) {
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				tsort(i, visited, stack);
			}
		}
	}

	public void tsort(int vertex, boolean[] visited, Stack<Integer> stack) {
		visited[vertex] = true;
		for (AdjListNode adj : adjs[vertex]) {
			if (!visited[adj.v]) {
				tsort(adj.v, visited, stack);
			}
		}
		stack.push(vertex);
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram. Here vertex numbers are
		// 0, 1, 2, 3, 4, 5 with following mappings:
		// 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
		LongestPathInDAG g = new LongestPathInDAG(6);
		/*
		 * g.addEdge(0, 1, 5); g.addEdge(0, 2, 3); g.addEdge(1, 3, 6);
		 * g.addEdge(1, 2, 2); g.addEdge(2, 4, 4); g.addEdge(2, 5, 2);
		 * g.addEdge(2, 3, 7); g.addEdge(3, 5, 1); g.addEdge(3, 4, -1);
		 * g.addEdge(4, 5, -2);
		 */
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(2, 5, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 5, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 1);
		int s = 1;
		System.out.println("Following are longest distances from source vertex ");
		g.longestPath(s);
		g.printPath(s);
		// INF 0 2 9 8 10
	}
}

class AdjListNode {
	int weight;
	int v;

	public AdjListNode(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
}
