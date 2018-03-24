package com.yahoo.util2;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String args[]) {
		String str = "tmmzuxt";
		//System.out.println(str.substring(1) + " :: "+ str.substring(0,str.length()-1));
		//System.out.println(lengthOfLongestSubstring(str));
		permulations("", str);
	}

	private static void permulations(String sofar, String remain) {
		if (remain.length() == 0) {
			return;
		}
		for (int i = 0; i < remain.length(); i++) {
			String str = remain.substring(0, i) + remain.substring(i+1);
			System.out.println(str);
			permulations(sofar + remain.charAt(i), str);
		}
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        int counts[] = new int[256];
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            if (counts[ch] != 0) {
                flag = true;
            }
            counts[ch]++;
            end++;
            while (flag) {
                if (s.charAt(start) == ch ) {
                    flag = false;
                }
                counts[s.charAt(start++)]--;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
