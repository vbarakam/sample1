package com.yahoo.util;

import java.util.*;

public class AlienDictionary {
	public static void main(String args[]) {
		String [] strs = {"za","zb","ca","cb"};
		System.out.println(alienOrder(strs));
	}
	
    public static String alienOrder(String[] words) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counter.put(c,0);
            }
        }
        
        for (int i = 0; i < words.length -1; i++) {
            String current = words[i];
            String next = words[i+1];
            int length = Math.min(current.length(), next.length());
            for (int k = 0; k < length; k++) {
                char w1 = current.charAt(k);
                char w2 = next.charAt(k);
                if (w1 != w2) {
                    Set<Character> v = map.get(w1);
                    if (v == null) {
                        v = new HashSet<>();
                    }
                    if (!v.contains(w2)) {
                        v.add(w2);
                        map.put(w1, v);
                        counter.put(w2, counter.get(w2) + 1);
                    }
                }
            }
        }
        
        // all zero value chars to queue
        Queue<Character> queu = new LinkedList<>();
        for (char k : counter.keySet()) {
            if (counter.get(k) == 0) {
                queu.add(k);
            }
        }
        
        // start with queue
        StringBuilder builder = new StringBuilder();
        while (!queu.isEmpty()) {
            char c = queu.remove();
            builder.append(c);
            if (map.containsKey(c)) {
                for(char c2: map.get(c)){
                    counter.put(c2, counter.get(c2) - 1);
                    if (counter.get(c2) == 0) {
                        queu.add(c2);
                    }
                }
            }
        }
        
        if (builder.length() != counter.size()) {
            return "";
        }
        
        return builder.toString();
    }
}
