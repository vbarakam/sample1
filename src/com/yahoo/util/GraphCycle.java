package com.yahoo.util;

import java.util.*;

public class GraphCycle {
	public static int timer = 0;

	public static void main(String args[]) {
		// list of node
		List<String> nodes = new ArrayList<>();
		nodes.add("m");
		nodes.add("n");
		nodes.add("o");
		nodes.add("p");
		nodes.add("q");
		nodes.add("r");
		nodes.add("s");
		nodes.add("t");
		nodes.add("v");
		nodes.add("u");
		nodes.add("w");
		nodes.add("x");
		nodes.add("y");
		nodes.add("z");
		Map<String, List<String>> adjs = new HashMap<>();

		List<String> mnodes = new ArrayList<>();
		mnodes.add("q");
		mnodes.add("r");
		mnodes.add("x");
		adjs.put("m", mnodes);

		List<String> nnodes = new ArrayList<>();
		nnodes.add("o");
		nnodes.add("q");
		nnodes.add("u");
		adjs.put("n", nnodes);

		List<String> onodes = new ArrayList<>();
		onodes.add("r");
		onodes.add("s");
		onodes.add("v");
		adjs.put("o", onodes);

		List<String> pnodes = new ArrayList<>();
		pnodes.add("z");
		pnodes.add("s");
		pnodes.add("o");
		adjs.put("p", pnodes);

		List<String> qnodes = new ArrayList<>();
		qnodes.add("t");
		adjs.put("q", qnodes);

		List<String> rnodes = new ArrayList<>();
		rnodes.add("u");
		rnodes.add("y");
		adjs.put("r", rnodes);

		List<String> snodes = new ArrayList<>();
		snodes.add("r");
		adjs.put("s", snodes);

		List<String> tnodes = new ArrayList<>();
		adjs.put("t", tnodes);

		List<String> unodes = new ArrayList<>();
		unodes.add("t");
		adjs.put("u", unodes);

		List<String> vnodes = new ArrayList<>();
		vnodes.add("w");
		vnodes.add("x");
		adjs.put("v", vnodes);

		List<String> wnodes = new ArrayList<>();
		wnodes.add("z");
		adjs.put("w", wnodes);

		List<String> ynodes = new ArrayList<>();
		ynodes.add("v");
		adjs.put("y", ynodes);

		List<String> znodes = new ArrayList<>();
		adjs.put("z", znodes);

		List<String> xnodes = new ArrayList<>();
		adjs.put("x", xnodes);
		Deque<String> deque = new LinkedList1<>();
		// dfs(nodes, adjs, deque);
		List<String> current = new ArrayList<String>();
		Map<String,Integer> counters = new HashMap<>();
		countPaths("m", adjs, "v", current, counters);
		System.out.println(" count " +  counters.get("v"));
	}

	public static void countPaths(String node, 
			Map<String, List<String>> edges, 
			String target,
			List<String> current,
			Map<String,Integer> counters) {
		
		// add given node to current
		current.add(node);

		// increment the counter
		Integer count = counters.get(node);
		if (count == null) {
			count = new Integer(0);
		}
		count += 1;
		counters.put(node, count);
		
		if (node.equals(target)) {
			System.out.println(current.toString());
			current.remove(node);
			return;
		} 
		
		for (String ed : edges.get(node)) {
			countPaths(ed, edges, target, current, counters);
		}
		current.remove(node);
	}

	public static void dfs(List<String> nodes, Map<String, List<String>> edges, Deque<String> deque) {
		// initialize all the required variable
		Map<String, Integer> colors = new HashMap<String, Integer>();
		Map<String, String> predecessors = new HashMap<String, String>();
		Map<String, Timer> timers = new HashMap<String, Timer>();

		for (String node : nodes) {
			colors.put(node, 0);
			predecessors.put(node, null);
		}

		// for each node call dfs visit
		for (String node : nodes) {
			if (colors.get(node) == 0) {
				dfsVisit(node, edges, colors, predecessors, timers, deque);
			}
		}
		System.out.println(" timers " + timers);
		System.out.println(" predecessors " + predecessors);
	}

	public static int dfsVisit(String node, Map<String, List<String>> edges, Map<String, Integer> colors,
			Map<String, String> predecessors, Map<String, Timer> timers, Deque<String> deque) {

		// start the timer
		timer = timer + 1;
		Timer time = timers.get(node);
		if (time == null) {
			time = new Timer();
			time.pre = timer;
			timers.put(node, time);
		}
		// change the color to grey
		colors.put(node, 1);
		System.out.println(node);
		for (String edge : edges.get(node)) {
			if (colors.get(edge) == 0) {
				predecessors.put(edge, node);
				timer = dfsVisit(edge, edges, colors, predecessors, timers, deque);
			}
		}

		// change the color to black
		colors.put(node, 2);
		deque.addFirst(node);
		// end the timer
		timer = timer + 1;
		time = timers.get(node);
		time.post = timer;
		return timer;
	}

	static class Timer {
		int pre;
		int post;

		public String toString() {
			return "pre : " + pre + " post : " + post;
		}
	}
	
	public static boolean checkCycles(List<String> nodes, Map<String, List<String>> adjs) {
		// initialize
		Map<String, Integer> colors = new HashMap<>();
		for (String node : nodes) {
			colors.put(node, 0);
		}
		
		boolean cycles = false;
		for (String node : nodes) {
			if (colors.get(node) == 0) {
				cycles = cycles || dfsVisit(node, adjs, colors);
			}
		}
		return cycles;
	}
	
	public static boolean dfsVisit(String node, 
			Map<String, List<String>> adjs,
			Map<String, Integer> colors) {
		// change the color to grey
		colors.put(node, 1);
		
		boolean cycles = false;
		for (String edge : adjs.get(node)) {
			// node refering to grey node indicates  a cycle
			if  (colors.get(edge) == 1) {
				return true;
			} else if (colors.get(edge) == 0) {
				cycles = cycles || dfsVisit(edge, adjs, colors);
			}
		}
		
		// change the color to black
		colors.put(node, 2);
		return cycles;
	}
}
