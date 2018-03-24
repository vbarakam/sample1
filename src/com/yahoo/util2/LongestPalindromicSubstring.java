package com.yahoo.util2;

public class LongestPalindromicSubstring {
	public static void main(String args[]) {
		String str = "babad";
		String str1 = "aa"
		System.out.println(longestPalindrome(str));
	}
	
	public static String longestPalindrome2(String s) {
		int maxLength = 1;
		int low = 0, high = 0;
		int m = s.length();
		int start = 0;
		for (int i = 1; i < s.length(); i++) {
			// even
			low = i-1;
			high = i;
			while (low >=0 && high < m && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}
			
			//odd
			low = i + 1;
			high = i-1;
			while (low >=0 && high < m && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				low--;
				high++;
			}
		}
		
	}
	
	public static String longestPalindrome(String s) {
        int index = 0;
        char str [] = new char[2 * s.length() +1];
        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                str[i] = '$';
            } else {
                str[i] = s.charAt(index++);
            }
        }
        
        int start = 0, end = 0;
        int [] cache = new int[str.length];
        int max = 0;
        int mStart = 0;
        int mEnd = 0;
        for (int i = 0; i < str.length;) {
            while (start > 0 && end < str.length -1 && str[start-1] == str[end+1]) {
                start--;
                end++;
            }
            cache[i] = end - start + 1;
            if (cache[i] > max) {
                max = cache[i];
                mStart = start;
                mEnd = end;
            }
            
            if (end == str.length -1) {
                break;
            }
            
            int newCenter = end + (i % 2 == 0 ? 1 : 0);
            
            for (int j = i+1; j <= end; j++) {
                cache[j] = Math.min(cache[i-(j-i)], 2 * (end-j) + 1);
                
                if (j + cache[i-(j-i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            
            i = newCenter;
            start = i - cache[i]/2;
            end = i + cache[i]/2;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = mStart; i <= mEnd; i++) {
            if (str[i] != '$') {
            	sb.append(str[i]);
            }
            
        }
        return sb.toString();
    }
}
