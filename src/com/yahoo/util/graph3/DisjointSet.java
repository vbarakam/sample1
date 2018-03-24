package com.yahoo.util.graph3;

import java.util.*;

public class DisjointSet {

	private Map<Integer, Node> map;

	public DisjointSet() {
		map = new HashMap<>();
	}

	class Node {
		int data;
		Node parent;
		int rank;

		public Node(int d) {
			data = d;
			parent = this;
			rank = 0;
		}
	}

	public void makeSet(int data) {
		Node node = new Node(data);
		map.put(data, node);
	}

	public int findSet(Node node) {
		if (node != node.parent) {
			node.parent = map.get(findSet(node.parent));
			return node.parent.data;
		}
		return node.data;
	}
	
	public int findSet(int data) {
		Node node = map.get(data);
		if (node != node.parent) {
			node.parent = map.get(findSet(node.parent));
			return node.parent.data;
		}
		return node.data;
	}

	public boolean union(int id1, int id2) {
		Node node1 = map.get(findSet(id1));
		Node node2 = map.get(findSet(id1));
		
		if (node1 == node2) {
			return false;
		}
		
		if (node1.rank > node2.rank) {
			node2.parent = node1;
		} else if (node1.rank < node2.rank) {
			node1.parent = node2;
		} else {
			node1.parent = node2;
			node2.rank = node2.rank+1;
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
