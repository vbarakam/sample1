package com.yahoo.util;

import java.util.*;

public class WordPattern {
	public static void main(String args[]) {
		String str1 = "abba";
		String str2 = "dog cat cat dog";
		wordPattern(str1, str2);
	}
	
	public static boolean wordPattern(String pattern, String str) {
        String split[] = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i< pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String g = map.get(pattern.charAt(i));
                if (!g.equals(split[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), split[i]);
            }
        }
        
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i< pattern.length();) {
            int j = i;
            while (j < pattern.length() && pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            lista.add(j-i);
            i = j;
        }
        
        List<Integer> listb = new ArrayList<>();
        for (int i = 0; i< pattern.length();) {
            int j = i;
            while (j < pattern.length() && split[i].equals(split[j])) {
                j++;
            }
            listb.add(j-i);
            i = j;
        }
        
        return lista.equals(listb);
    }
}
