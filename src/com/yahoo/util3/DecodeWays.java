package com.yahoo.util3;

import java.util.*;

public class DecodeWays {
	public static void main(String args[]) {
		DecodeWays decode = new DecodeWays();
		System.out.println(decode.numDecodings("01"));
	}
	
	
	private int counter = 0;
    public int numDecodings2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        numDecodings(s, 0, "");
        return counter;
    }
    
    public void numDecodings(String str, int index, String result) {
        if (index == str.length()) {
            counter++;
            return;
        }
        int single = str.charAt(index) - '1';
        if (single >= 0) {
            numDecodings(str, index+1, result + ('A' + single));
        }
        if (index + 1 < str.length()) {
            int double2 = Integer.parseInt(str.substring(index, index+2));
            if (double2 < 27 && double2 > 0 ) {
                numDecodings(str, index+2, result + ('A' + double2 -1));
            }
        }
    }
    
	public static int numDecodings(String str) {
        int f = dfs(str, str.substring(0,1), str.substring(1));
        int s = dfs(str, str.substring(0,2), str.substring(2));
        return f +s ;
    }
    
    private static int dfs(String str, String prefix, String remain) {
        Integer temp = new Integer(prefix);
        
        if (remain.length() == 0 && (temp > 0 || temp < 27)) {
            return 1;
        }
        if (temp < 1 || temp > 26) {
            return 0;
        }
        
        return (remain.length() >= 1 ? dfs(str, remain.substring(0,1), remain.substring(1)) : 0) + (remain.length() >= 2 ? dfs(str, remain.substring(0,2), remain.substring(2)) : 0);
    }
}
