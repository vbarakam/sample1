package com.yahoo.util2;

import java.util.*;

public class AlienDictionary {
	public static void main(String args[]) {
		String p[] = {"za","zb","ca","cb"};
		System.out.println(alienOrder(p));
	}
	
	 public static String alienOrder(String[] words) {
	        Map<Character, Integer> cache = new HashMap<>();
	        for (String word : words) {
	            for (char c : word.toCharArray()) {
	                cache.put(c, 0);
	            }
	        }
	        
	        Map<Character, List<Character>> map = new HashMap<>();
	        for (int i = 0; i < words.length -1; i++) {
	            String word1 = words[i];
	            String word2 = words[i+1];
	            int len = Math.min(word1.length(), word2.length());
	            for (int ii = 0; ii < len; ii++) {
	                if (word1.charAt(ii) != word2.charAt(ii)) {
	                    List<Character> ends = map.get(word1.charAt(ii));
	                    if (ends == null) {
	                        ends = new ArrayList<>();
	                    }
	                    if (!ends.contains(word2.charAt(ii))) {
	                        ends.add(word2.charAt(ii));
	                    }
	                    map.put(word1.charAt(ii), ends);
	                    cache.put(word2.charAt(ii), cache.get(word2.charAt(ii)) + 1);
	                    break;
	                }
	            }
	        }
	            
	        // get all the zero count
	        Queue<Character> zeroCount = new LinkedList<>();
	        for (Map.Entry<Character, Integer> entry : cache.entrySet()) {
	            if (entry.getValue() == 0) {
	                zeroCount.add(entry.getKey());
	            }
	        }
	            
	        // start with zero ends
	        StringBuilder builder = new StringBuilder();
	        while (!zeroCount.isEmpty()) {
	            char c = zeroCount.remove();
	            builder.append(Character.toString(c));
	            List<Character> ss = map.get(c);
	            if (ss == null) {
	                continue;
	            }
	            for (char c2 : ss) {
	                cache.put(c2, cache.get(c2) - 1);
	                if (cache.get(c2) == 0) {
	                    zeroCount.add(c2);
	                }
	            }
	        }
	        
	        if (cache.size() != builder.length()) {
	            return "";
	        }
	        return builder.toString();
	    }
}
