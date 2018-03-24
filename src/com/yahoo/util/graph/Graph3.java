package com.yahoo.util.graph;

import java.util.*;

public class Graph3<T> {
	private boolean isDirected;
	private List<Edge3<T>> allEdges;
	private Map<Long, Vertex3<T>> allVertex;

	public Graph3(boolean isDirected) {
		this.isDirected = isDirected;
		allEdges = new ArrayList<>();
		allVertex = new HashMap<>();
	}

	public void addEdge(long id1, long id2) {
		Vertex3<T> first = null;
		if (allVertex.containsKey(id1)) {
			first = allVertex.get(id1);
		} else {
			first = new Vertex3(id1);
			allVertex.put(id1, first);
		}
		Vertex3<T> second = null;
		if (allVertex.containsKey(id2)) {
			second = allVertex.get(id2);
		} else {
			second = new Vertex3(id2);
			allVertex.put(id2, second);
		}

		Edge3<T> edge = new Edge3(first, second, isDirected, 0);
		allEdges.add(edge);
		first.addAdjacentVertex(second, edge);
		if (!isDirected) {
			second.addAdjacentVertex(first, edge);
		}
	}
}

class Vertex3<T> {
	private long id;
	private T data;
	private List<Edge3<T>> edges;
	private List<Vertex3<T>> adjacentVertex;

	Vertex3(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Edge3<T>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge3<T>> edges) {
		this.edges = edges;
	}

	public List<Vertex3<T>> getAdjacentVertex() {
		return adjacentVertex;
	}

	public void setAdjacentVertex(List<Vertex3<T>> adjacentVertex) {
		this.adjacentVertex = adjacentVertex;
	}

	public void addAdjacentVertex(Vertex3<T> vertex, Edge3<T> edge) {
		edges.add(edge);
		adjacentVertex.add(vertex);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) id;
		return result;
	}

	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}

		if (otherObject == null) {
			return false;
		}

		if (getClass() != otherObject.getClass()) {
			return false;
		}

		if (!(otherObject instanceof Vertex3)) {
			return false;
		}

		Vertex3<T> other = (Vertex3) otherObject;

		return id == other.getId();
	}

}

class Edge3<T> {
	private boolean isDirected;
	private Vertex3<T> vertex1;
	private Vertex3<T> vertex2;
	private int weight;

	Edge3(Vertex3<T> vertex1, Vertex3<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Vertex3<T> getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex3<T> vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex3<T> getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex3<T> vertex2) {
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (vertex1 == null ? 0 : vertex1.hashCode());
		result = result * 11 + (vertex2 == null ? 0 : vertex2.hashCode());
		return result;
	}

	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}

		if (otherObject == null) {
			return false;
		}

		if (getClass() != otherObject.getClass() || !(otherObject instanceof Edge3)) {
			return false;
		}

		Edge3 other = (Edge3) otherObject;
		if ((vertex1 == null && other.getVertex1() != null) || (vertex1 != null && other.getVertex1() == null)
				|| (vertex2 == null && other.getVertex2() != null) || (vertex2 != null && other.getVertex2() == null)) {
			return false;

		}
		return vertex1.equals(other.getVertex1()) && vertex2.equals(other.getVertex2());
	}
}
