package com.yahoo.util2;

import java.util.*;

public class WordBreakII {
	public static void main(String args[]) {
		String str = "catsanddog";
		String dict[] = {"cat", "cats", "and", "sand", "dog"};
		System.out.println(dfs(str, Arrays.asList(dict), new HashMap<String, List<String>>()));
	}
	
	//	s = "catsanddog",
	//	dict = ["cat", "cats", "and", "sand", "dog"]. 
	private static List<String> dfs(String str, List<String> words, Map<String, List<String>> map) {
		if (map.containsKey(str)) {
			return map.get(str);
		}
		
		List<String> dicWords = new ArrayList<>();
		// check if str is empty
		if (str.length() == 0) {
			dicWords.add("");
			return dicWords;
		}
		
		// for each word in words check if str start with given word
		for (String word : words) {
			if (str.startsWith(word)) {
				List<String> dicWords2 = dfs(str.substring(word.length()), words, map);
				for (String sub : dicWords2) {
					dicWords.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		map.put(str, dicWords);
		return dicWords;
	}
}
