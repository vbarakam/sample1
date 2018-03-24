package com.yahoo.util;

import java.util.ArrayList;
import java.util.List;

public class StringPartition {
	public static void main(String args[]) {
		String str = "leetcode";
		//p(str, "", "", 0, str.length() -1);
		//w(str);
		String str1 = "a";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		//wordDict.add("abc");
		//wordDict.add("b");
		//wordDict.add("cd");
		System.out.println(wordBreak(str1, wordDict));
	}
	
	public static boolean wordBreak(String str, List<String> wordDict) {
        for (int t = 0; t < str.length(); t++) {
			String str1 = str.substring(0, t);
			String str2 = str.substring(t);
			if ((str1.length() == 0 || wordDict.contains(str1)) && (str2.length() == 0 || wordDict.contains(str2) || wordBreak(str2, wordDict))) {
			    return true;  
			}
		}
		return false;
    }
	
	public static void w(String str) {
		for (int t = 0; t < str.length(); t++) {
			System.out.println(str.substring(0, t) + " : " + str.substring(t));
		}
	}
	
	public static void p(String rest, String prefixSofar, String suffixSofar, int low, int high) {
		if (low <= high) {
			int mid = (low + high)/2;
			
			// check low to mid and mid +1 to high
			System.out.println( prefixSofar + ": " + rest.substring(low, mid+1) + ": " + rest.substring(mid + 1) + ": " + suffixSofar );
			
			// left
			p(rest.substring(low, mid+1), prefixSofar, suffixSofar +  rest.substring(mid + 1) , low, mid+1);
			
			// right
			p(rest.substring(mid + 1), prefixSofar + rest.substring(low, mid+1), suffixSofar, mid+1, high);
		}
	}
}
