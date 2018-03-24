package com.yahoo.util2;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public static void main(String args[]) {
		String str = "eceba";
		System.out.println(lengthOfLongestSubstringKDistinct(str,2));
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int start = 0, end = 0, counter = 0, max = Integer.MIN_VALUE;
		int counts[] = new int[256];
		
		for (char ch : s.toCharArray()) {
			if (counts[ch] == 0) {
				counter++;
			}
			counts[ch]++;
			end++;
			
			while (counter > k) {
				max = Math.max(max, end-start-1);
				
				if (--counts[s.charAt(start++)] == 0) {
					counter--;
				}
			}
			max = Math.max(max, end-start);
			
		}
		return max;
	}
	public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int start = 0, end = 0, m = s.length();
        int [] data = new int[128];
        int counter = 0, maxLgn = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (data[c] <= 0) {
                counter++;
            }
            data[c]++;
            end++;
            
            while (counter > k) {
                maxLgn =  Math.max(maxLgn, end - 1 - start);
                data[s.charAt(start)] = 0;
                start++;
                counter--;
            }
        }
        return maxLgn;
    }
}

