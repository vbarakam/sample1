package com.yahoo.util.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Graph<T> {
	private List<Edge<T>> allEdges;
	private Map<Integer, Vertex<T>> allVertex;
	private boolean isDirected = false;

	public Graph() {
		allEdges = new ArrayList<>();
		allVertex = new HashMap<>();
	}

	public Graph(boolean isDirected) {
		this();
		this.isDirected = isDirected;
	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public void setAllEdges(List<Edge<T>> allEdges) {
		this.allEdges = allEdges;
	}

	public Map<Integer, Vertex<T>> getAllVertex() {
		return allVertex;
	}

	public void setAllVertex(Map<Integer, Vertex<T>> allVertex) {
		this.allVertex = allVertex;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addEdge(Integer id1, Integer id2, int weight) {
		Vertex<T> vertex1 = null;
		if (!allVertex.containsKey(id1)) {
			// add vertex
			vertex1 = addVertex(id1);
		} else {
			vertex1 = allVertex.get(id1);
		}

		Vertex<T> vertex2 = null;
		if (!allVertex.containsKey(id2)) {
			// add vertex
			vertex2 = addVertex(id2);
		} else {
			vertex2 = allVertex.get(id2);

		}

		Edge<T> edge = new Edge<>(vertex1, vertex2, isDirected);
		edge.setWeight(weight);
		allEdges.add(edge);

		vertex1.addAdjacentVertex(edge, vertex2);
	}

	public Vertex<T> addVertex(Integer id) {
		if (!allVertex.containsKey(id)) {
			Vertex<T> vertex = new Vertex<>();
			vertex.setId(id);
			allVertex.put(id, vertex);
			return vertex;
		} else {
			return allVertex.get(id);
		}
	}
}

class Vertex<T> {
	private Integer id;
	public T distance;
	private List<Edge<T>> edges;
	private List<Vertex<T>> adjacentVertex;

	public Vertex() {
		edges = new ArrayList<>();
		adjacentVertex = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public T getData() {
		return distance;
	}

	public void setData(T data) {
		this.distance = data;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge<T>> edges) {
		this.edges = edges;
	}

	public List<Vertex<T>> getAdjacentVertex() {
		return adjacentVertex;
	}

	public void setAdjacentVertex(List<Vertex<T>> adjacentVertex) {
		this.adjacentVertex = adjacentVertex;
	}

	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertex.add(v);
	}
	
	public String toString() {
		return "Vertex id : " + this.id + " : distance : " + distance;
	}
}

class Edge<T> {
	private int weight;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private boolean isDirected;

	public Edge() {
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}

	public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Vertex<T> getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex<T> vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex<T> getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex<T> vertex2) {
		this.vertex2 = vertex2;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}
}
