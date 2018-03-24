package com.yahoo.util.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Knapsack01 {
	public static void main(String args[]) {
		String str1 = "ab";
		String str2 = "b";
		minWindow(str1, str2);
	}
	
	public static String minWindow(String s, String t) {
        int start = 0, end = 0, counter = t.length(), head = 0, d = Integer.MAX_VALUE;
        int counts[] = new int[26];
        for (char ch : t.toCharArray()) {
            counts[ch-'a']++;
        }
        while (end < s.length()) {
            if (counts[s.charAt(end++)-'a']-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (d > end - start) {
                    head = start;
                    d = end - start;
                }
                if (counts[s.charAt(start++)]-- >= 0) {
                    counter++;
                }
            }
        }
        return d != Integer.MAX_VALUE ? s.substring(head, head+d) : "";
    }
	
	
	
	public static String longestPalindrome(String s) {
        int max = 1, left = 0, right = 0, head = 0;
        for (int i = 1; i < s.length(); i++) {
            left = i-1;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (max < (right - left + 1)) {
                    max = right - left +1;
                    head = left;
                }
            }
            left = i-1;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
               if (max < (right - left + 1)) {
                    max = right - left +1;
                    head = left;
                }
            }
        }
        return s.substring(head, head+max);
    }
	public int knapsack(int val[], int wt[], int target) {
		int dp[][] = new int[wt.length+1][target+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j-wt[i-1] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[wt.length][target];
	}
	
	
	
	public int bottomUpDP(int val[], int wt[], int W){
		int dp [][] = new int[wt.length + 1][W+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j - wt[i-1] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i][j-wt[i-1]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[wt.length][W];
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	public int bottomUpDP3(int val[], int wt[], int W){
		int data[][] = new int[val.length+1][W + 1];
		for (int i = 0; i <= wt.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					data[i][j] = 0;
					continue;
				}
				
				if ((j - wt[i-1]) >= 0) {
					data[i][j] = Math.max(data[i-1][j], val[i-1] + data[i-1][j-wt[i-1]]);
				} else {
					data[i][j] = data[i-1][j];
				}
			}
			
		}
		return data[val.length][W];
	}
	
	public int bottomUpDP2(int val[], int wt[], int W){
		int d[][] = new int[wt.length+1][W+1];
		for (int i = 1; i <= wt.length; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i-1] <= j ) {
					d[i][j] = Math.max(val[i-1] + d[i-1][j-wt[i-1]], d[i-1][j]);
				} else {
					d[i][j] = d[i-1][j];
				}
			}
		}
		
		int w = d[wt.length][W];
		List<Integer> items = new ArrayList<>();
		int i = wt.length;
		int j = W;
		while (w > 0) {
			if (d[i][j] != d[i-1][j]) {
				items.add(val[i-1]);
				w -=  val[i-1];
				i = i -1;
				j = j - wt[i-1];
			} else {
				i = i -1;
			}
			
		}
		System.out.println(" items " + items);
		return d[wt.length][W];
	}
}
