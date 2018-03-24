package com.yahoo.util;

import java.util.*;

public class PalindromePartitioning {
	private static List<List<String>> resultLst;
    private static ArrayList<String> currLst;
    
	public static void main(String args[]) {
		currLst = new ArrayList<>();
		resultLst = new ArrayList<>();
		backTrack("aab", 0);
		System.out.println(resultLst);
	}
	
	 public static void backTrack(String s, int l) {
		 if (l >= s.length()) {
			 List<String> curr = new ArrayList<>();
			 curr.addAll(currLst);
			 resultLst.add(curr);
		 }
		 for (int i = l; i < s.length(); i++) {
			 if (palindrome(s, l, i)) {
				 if (l == i) {
					 System.out.println(s.charAt(l));
					 currLst.add(Character.toString(s.charAt(l)));
				 } else {
					 System.out.println(s.substring(l, i + 1));
					 currLst.add(s.substring(l, i + 1));
				 }
				 backTrack(s, i+1);
				 currLst.remove(currLst.size() -1);
			 }
		 }
	 }
	private static boolean palindrome(String str, int left, int right) {
		if (left == right) {
			return true;
		}
		
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
