package com.yahoo.util3;

import java.util.*;
import java.util.stream.*;

public class Test3 {
	public static void main(String args[]) {
		System.out.println(accountsMerge(Arrays.asList(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),
				Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),
				Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),
				Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),
				Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"))));
		
	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> results = new ArrayList<>();
		Map<String, List<List<String>>> group = accounts.stream().collect(Collectors.groupingBy(list -> list.get(0)));
		for (Map.Entry<String, List<List<String>>> entry : group.entrySet()) {
			if (entry.getValue().size() == 1) {
				List<String> result = new ArrayList<>();
				Set<String> emails = new HashSet();
				for (int i = 1; i < entry.getValue().get(0).size(); i++) {
					emails.add(entry.getValue().get(0).get(i));
				}
				result.addAll(emails);
				Collections.sort(result);
				result.add(0, entry.getValue().get(0).get(0));
				results.add(result);
			} else {
				List<List<String>> groupByName = entry.getValue();
				Map<String, List<List<String>>> emailGroup = new HashMap<>();
				for (List<String> group2 : groupByName) {
					for (int i = 1; i < group2.size(); i++) {
						List<List<String>> gg = emailGroup.get(group2.get(i));
						if (gg == null) {
							gg = new ArrayList<>();
							emailGroup.put(group2.get(i), gg);
						}
						gg.add(group2);
					}
				}
				Set<String> visited = new HashSet<>();
				for (List<String> group2 : groupByName) {
					Set<String> emails = new HashSet<>();
					for (int i = 1; i < group2.size(); i++) {
						List<List<String>> gggg = emailGroup.get(group2.get(i));
						//visited.contains(group2.get(i)) ||
						if ( gggg == null) {
							continue;
						}
						emailGroup.remove(group2.get(i));
						for (List<String> z : gggg) {
							emails.addAll(z);
							visited.addAll(z);
						}
					}
					if (emails.size() == 0) {
						continue;
					}
					List<String> result = new ArrayList<>();
					emails.remove(group2.get(0));
					result.addAll(emails);
					Collections.sort(result);
					result.add(0, group2.get(0));
					results.add(result);
				}
			}
		}
		return results;
	}
}
