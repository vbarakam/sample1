package com.yahoo.util;

import java.util.*;

public class WordBreak {
	public static void main(String args[]) {
		String str = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		Map<String, List<String>> cache = new HashMap<>();
		List<String> results = breakWord(str, wordDict, cache);
		System.out.println(results);
		System.out.println(cache);
	}
	
	private static List<String> breakWord(String str, List<String> wordDict, Map<String, List<String>> cache) {
        if (cache.containsKey(str)) {
        	return cache.get(str);
        }
        
		List<String> results = new ArrayList<>();
        if (str.length() == 0) {
            results.add(str);
            return results;
        }
        
        for (String dict : wordDict) {
            if (str.startsWith(dict)) {
                List<String> subresults = breakWord(str.substring(dict.length()), wordDict, cache);
                for (String st : subresults) {
                	results.add(dict + (st.isEmpty() ? "" : " ") + st);
                }
            }
        }
        cache.put(str, results);
        return results;
    }
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        boolean f[] = new boolean[s.length()+1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j,i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        System.out.println(f);
        return f[s.length()];
    }
}
