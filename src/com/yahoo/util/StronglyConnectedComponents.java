package com.yahoo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StronglyConnectedComponents {

	public static void main(String args[]) {
		// list of node
		List<String> nodes = new ArrayList<>();
		nodes.add("c");
		nodes.add("b");
		nodes.add("a");

		nodes.add("d");
		nodes.add("e");
		nodes.add("f");
		nodes.add("g");
		nodes.add("h");

		Map<String, List<String>> adjs = new HashMap<>();

		List<String> mnodes = new ArrayList<>();
		mnodes.add("b");
		adjs.put("a", mnodes);

		List<String> nnodes = new ArrayList<>();
		nnodes.add("c");
		nnodes.add("e");
		nnodes.add("f");
		adjs.put("b", nnodes);

		List<String> onodes = new ArrayList<>();
		onodes.add("g");
		onodes.add("d");
		adjs.put("c", onodes);

		List<String> pnodes = new ArrayList<>();
		pnodes.add("c");
		pnodes.add("h");
		adjs.put("d", pnodes);

		List<String> qnodes = new ArrayList<>();
		qnodes.add("a");
		qnodes.add("f");
		adjs.put("e", qnodes);

		List<String> rnodes = new ArrayList<>();
		rnodes.add("g");
		adjs.put("f", rnodes);

		List<String> gnodes = new ArrayList<>();
		gnodes.add("f");
		gnodes.add("h");
		adjs.put("g", gnodes);

		List<String> hnodes = new ArrayList<>();
		adjs.put("h", hnodes);
		// initialize
		Map<String, Integer> colors = new HashMap<>();
		Map<String, Timer> timers = new HashMap<>();
		Map<String, String> predessor = new HashMap<>();

		dfs(nodes, adjs, colors, timers, predessor);

		System.out.println("  colors " + colors);
		System.out.println("  timers " + timers);
		System.out.println("  predessor " + predessor);

		Map<String, List<String>> nadjs = transpose(nodes, adjs);
		System.out.println(" nadjs " + nadjs);

		// run dfs with descreasing d
		Map<String, String> predessor2 = new HashMap<>();
		Map<String, Integer> colors2 = new HashMap<>();
		Map<String, Timer> timers2 = new HashMap<>();
		// sort nodes based on decreasing order of post time
		Map<Integer, String> sorted = new TreeMap<>();
		for (String node : timers.keySet()) {
			sorted.put(timers.get(node).post, node);
		}
		
		List<String> rNodes = new ArrayList<>(sorted.values());
		Collections.reverse(rNodes);
		System.out.println(" sorted value " + rNodes);
		dfs(rNodes, nadjs, colors2, timers2, predessor2);
		
		System.out.println("  colors2 " + colors2);
		System.out.println("  timers2 " + timers2);
		System.out.println("  predessor2 " + predessor2);
		
		// collect strongly connected components
		predessor = new HashMap<>();
		for (String node : predessor2.keySet()) {
			if (predessor2.get(node) != null) {
				predessor.put(predessor2.get(node), node);
			}
		}
		
		for (String node : predessor2.keySet()) {
			if (predessor2.get(node) == null) {
				System.out.print("  group " + node);
				while (predessor.get(node) != null) {
					System.out.print(" " + predessor.get(node));
					node =  predessor.get(node);
				}
			}
		}
		
	}

	// run dfs
	public static void dfs(List<String> nodes, Map<String, List<String>> adjs, Map<String, Integer> colors,
			Map<String, Timer> timers, Map<String, String> predessor) {

		for (String node : nodes) {
			colors.put(node, 0);
			predessor.put(node, null);
			timers.put(node, new Timer());
		}

		// call dfsVisit
		int timer = 0;
		for (String node : nodes) {
			if (colors.get(node) == 0) {
				timer = dfsVisit(node, timer, adjs, colors, timers, predessor);
			}
		}

	}

	public static int dfsVisit(String node, int timer, Map<String, List<String>> adjs, Map<String, Integer> colors,
			Map<String, Timer> timers, Map<String, String> predessor) {

		// set start time
		timer += 1;
		Timer time = timers.get(node);
		time.pre = timer;

		// set grey color
		colors.put(node, 1);

		// recursively process the nodes
		for (String edge : adjs.get(node)) {
			if (colors.get(edge) == 0) {
				predessor.put(edge, node);
				timer = dfsVisit(edge, timer, adjs, colors, timers, predessor);
			}
		}

		// set end time
		timer += 1;
		time.post = timer;

		// update black color
		colors.put(node, 2);

		return timer;
	}

	// transpose G
	public static Map<String, List<String>> transpose(List<String> nodes, Map<String, List<String>> adjs) {
		Map<String, List<String>> newadjs = new HashMap<>();
		for (String node : adjs.keySet()) {
			List<String> es = adjs.get(node);
			for (String e : es) {
				List<String> ess = newadjs.get(e);
				if (ess == null) {
					ess = new ArrayList<String>();
					newadjs.put(e, ess);
				}
				ess.add(node);
			}
		}
		return newadjs;

	}
	// run dfs with descreasing d
	// collect strongly connected components

	static class Timer {
		int pre;
		int post;

		public String toString() {
			return " pre : " + pre + " post : " + post;
		}
	}
}
