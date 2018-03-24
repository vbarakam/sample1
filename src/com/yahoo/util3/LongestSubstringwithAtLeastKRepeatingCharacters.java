package com.yahoo.util3;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String args[]) {
		String str = "ababab";
		int k = 3;
		System.out.println(longestSubstring(str, k));
	}
	
	public static int longestSubstring(String s, int k) {
        return substring(s, 0, s.length(), k);
    }
    
    private static int substring(String str, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }
        int counts[] = new int[26];
        for (int i = start; i < end; i++) {
            counts[str.charAt(i)-'a']++;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < k && counts[i] > 0) {
                for (int j = start; j < end; j++) {
                    if (i == (str.charAt(j) - 'a')) {
                        int left = substring(str, start, j, k);
                        int right = substring(str, j+1, end, k);
                        max = Math.max(left, right);
                    }
                }
                return max;
            }
        }
        return end - start;
    }
}
