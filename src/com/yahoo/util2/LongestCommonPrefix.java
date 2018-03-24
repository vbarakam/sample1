package com.yahoo.util2;

public class LongestCommonPrefix {
	public static void main(String args []) {
		String strs [] = {"c","c"};
		longestCommonPrefix(strs);
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        int len = findMinStrLength(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            int j = 1;
            for (j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
    private static int findMinStrLength(String strs []) {
        int min  = 0;
        for (int j = 1; j < strs.length; j++) {
            min = Math.min(min, strs[j].length());
        }
        return min;
    }
}
