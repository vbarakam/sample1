package com.yahoo.util2;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public static void main(String args[]) {
		String str = "aaabbb";
		int target = 3;
		System.out.println(longestSubstring(str, target));
	}
	
	public static int longestSubstring(String s, int k) {
        char str [] = s.toCharArray();
        return helper(str, 0, str.length, k);
    }
    
    private static int helper(char str [], int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        
        int count[] = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i]-'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j+1, end, k);
                        return Math.max(left,right);
                    }
                    
                }
            }
        }
        return end - start;
    }
}
