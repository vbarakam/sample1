package com.yahoo.util3;

import java.util.*;

public class GroupShiftedStrings {
	public static void main(String args[]) {
		String strs[] = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		System.out.println(groupStrings(strs));
	}

	public static List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> groups = new HashMap<>();
		for (String str : strings) {
			String hash = hashString(str);
			List<String> group = groups.get(hash);
			if (group == null) {
				group = new ArrayList<>();
				groups.put(hash, group);
			}
			group.add(str);
		}
		List<List<String>> results = new ArrayList<>();
		results.addAll(groups.values());
		return results;
	}

	private static String hashString(String str) {
		if (str.length() == 1) {
			return "1";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			sb.append(hascode(str.charAt(i), str.charAt(i+1))).append("-");
		}
		return sb.toString();
	}

	private static int hascode(char c1, char c2) {
		return c1 - c2 < 0 ? c1-c2+26 : c1-c2;
	}
}
