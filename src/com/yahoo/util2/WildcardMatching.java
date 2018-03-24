package com.yahoo.util2;

public class WildcardMatching {
	public static void main(String args[]) {
		String str1 = "aa";
		String str2 = "a";
		System.out.println(isMatch(str1, str2));
	}
	
	public static boolean isMatch(String s, String p) {
        // remove double starts
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (first) {
                    sb.append(Character.toString(p.charAt(i)));
                }
                first = false;
            } else {
                sb.append(Character.toString(p.charAt(i)));
                first = true;
            }
        }
        
        boolean result[][] = new boolean[s.length() + 1][sb.length() + 1];
		result[0][0] = true;
        String nstr = sb.toString();
        if (nstr.startsWith("*")) {
            result[0][1] = true;
        }
        
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (s.charAt(i-1) == nstr.charAt(j-1) || nstr.charAt(j-1) == '?') {
                    result[i][j] = result[i-1][j-1];
                } else if (nstr.charAt(j-1) == '*') {
                    result[i][j] = result[i][j-1] || result[i-1][j];
                } else {
                    result[i][j] = false;
         ange@1234       }
            }
        }
        
        return result[p.length()][nstr.length()];
    }
	
	public static boolean isMatch2(String s, String p) {
        // remove multiple occurance of *
        boolean firstTime = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < p.length(); i ++) {
            if (p.charAt(i) == '*') {
                if (firstTime) {
                    builder.append(Character.toString(p.charAt(i)));
                }
                firstTime = false;
            } else {
            	builder.append(Character.toString(p.charAt(i)));
                firstTime = true;
            }
        }
        
        String newPattern = builder.toString();
        boolean result [][] = new boolean[s.length()+1][newPattern.length()+1];
        result[0][0] = true;
        
        if (newPattern.startsWith("*") && result[0].length > 1) {
            result[0][1] = true; 
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= newPattern.length(); j++) {
                if (s.charAt(i-1) == newPattern.charAt(j-1) || newPattern.charAt(j-1) == '?') {
                    result[i][j] = result[i-1][j-1];
                } else if (newPattern.charAt(j-1) == '*') {
                    result[i][j] = result[i-1][j] || result[i][j-1] ;
                } else {
                    result[i][j] = false;
                }
            }
        }
        
        return result[s.length()][newPattern.length()];
        
    }
}
