package com.yahoo.util2;

import java.util.*;

public class FindAllAnagramsinaString {
	public static void main(String args[]) {
		String str1 = "cbaebabacd";
		String str2 = "abc";
		System.out.println(findAnagrams(str1, str2));
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        
      // list of all p elements
        int pchars [] = new int[26];
        for (char c : p.toCharArray()) {
            pchars[c - 'a']++;
        }
        
        
        //s: "cbaebabacd" p: "abc"
        // counter
        int start = 0, end = 0, n = s.length(), count = p.length();
        
        while (end < n) {

            if (end - start == p.length() && pchars[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
            
            if (pchars[s.charAt(end++) - 'a']-- > 0) {
                count--;
            }
            
            if (count == 0) {
                results.add(start);
            }
        }
        
        return results;
    }
}
