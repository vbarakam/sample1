package com.yahoo.util3;

import java.util.*;

public class CourseSchedule {

	public static void main(String args[]) {
		int ii = 6;
		for (int i = 0; i < ii; i++) {
			System.out.println(i + " -> " + index(ii, i));
		}
	}
	
	private static int index(int n, int i) {
		return (1+2*i) % (n|1);
	}
	public static void main3(String args[]) {
		int courses = 4;
		int data[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(findOrder(4, data));
	}

	public static void main2(String args[]) {
		int courses = 4;
		int data[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(canFinish(4, data));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> counters = new HashMap<>();
		ArrayList<Integer> adjs[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adjs[i] = new ArrayList<Integer>();
			counters.put(i, 0);
		}

		Map<Integer, List<Integer>> dpgraph = new HashMap<>();
		for (int[] prerequisite : prerequisites) {
			adjs[prerequisite[1]].add(prerequisite[0]);
			List<Integer> deps = dpgraph.get(prerequisite[1]);
			if (deps == null) {
				deps = new ArrayList<Integer>();
				dpgraph.put(prerequisite[1], deps);
			}
			if (!deps.contains(prerequisite[0])) {
				deps.add(prerequisite[0]);
				counters.put(prerequisite[0], counters.getOrDefault(prerequisite[0], 0) + 1);
			}
		}
		// get zero values
		List<Integer> zeros = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : counters.entrySet()) {
			if (entry.getValue() == 0) {
				zeros.add(entry.getKey());
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.addAll(zeros);
		System.out.println("zeros " + zeros);
		System.out.println("deps " + dpgraph);
		int[] results = new int[numCourses];
		int index = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			results[index++] = course;
			if (dpgraph.containsKey(course) && dpgraph.get(course).size() > 0) {
				for (int dep : dpgraph.get(course)) {
					counters.put(dep, counters.getOrDefault(dep, 0) - 1);
					if (counters.get(dep) == 0) {
						queue.add(dep);
					}
				}
			}
		}
		System.out.println(index);
		return index != numCourses ? new int[0] : results;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean visited[] = new boolean[numCourses];
		List<Integer> edges[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<>();
		}

		// build adj graph
		for (int i = 0; i < prerequisites.length; i++) {
			edges[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		List<Integer> stack = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.add(i);
				boolean status = visit(i, visited, stack, edges);
				if (status) {
					return false;
				}
				stack.clear();
			}
		}

		return true;
	}

	private static boolean visit(int course, boolean visited[], List<Integer> stack, List<Integer> edges[]) {
		boolean status = false;
		for (Integer edge : edges[course]) {
			if (stack.contains(edge)) {
				return true;
			}
			stack.add(edge);
			if (!visited[edge]) {
				visited[edge] = true;
				status = status || visit(edge, visited, stack, edges);
			}
			stack.remove(edge);
		}
		return status;
	}
}
