package com.yahoo.util.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Union by Rank and path compression.
 * 
 * @author vbarakam
 *
 */
public class DisjointSet {
	Map<Integer, Node> map = new HashMap<>();

	static class Node {
		int data;
		int rank;
		Node parent;

		public Node(int data) {
			this.data = data;
			this.rank = 0;
			parent = this;
		}
	}

	public void makeSet(int data) {
		Node node = new Node(data);
		map.put(data, node);
	}

	public Node findSet(int data) {
		Node node = map.get(data);
		if (node.parent == node) {
			return node;
		}

		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	public boolean union(int key1, int key2) {
		Node node1 = map.get(key1);
		Node node2 = map.get(key2);

		Node parent1 = findSet(node1.data);
		Node parent2 = findSet(node2.data);
		if (parent1.data == parent2.data) {
			return false;
		}

		if (parent1.rank >= parent2.rank) {
			parent2.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}

		return true;
	}

	public static void main(String args[]) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));
	}
}
