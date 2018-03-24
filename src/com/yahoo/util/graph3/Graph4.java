package com.yahoo.util.graph3;

import java.util.*;

public class Graph4<T> {
	private boolean isDirected;
	private List<Edge<T>> allEdges;
	private Map<Integer, Vertex<T>> allVertices;
	
	public void addEdge(Integer id1, Integer id2, int weight) {
		
	}
	
	public Vertex addVertex() {
		return null;
	}
}

class Vertex<T> {
	private Integer id;
	private T distance;
	private List<Edge<T>> adjacentEdges;
	private List<Vertex<T>> adjacentVertices;
	
}

class Edge<T> {
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;
	private boolean isDirected;
}
