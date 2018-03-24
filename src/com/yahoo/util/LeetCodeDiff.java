package com.yahoo.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeetCodeDiff {

	public static void main3(String args[]) throws IOException {
		String fileName1 = "/Users/vbarakam/Downloads/old_session_1.txt";
		Set<String> results1 = fetchProblemSet(fileName1);
		String fileName2 = "/Users/vbarakam/Downloads/new_session_1.txt";
		Set<String> results2 = fetchProblemSet(fileName2);

		results1.removeAll(results2);
		System.out.println(results1.size());
		results1.forEach( p -> System.out.println(p));
	}
	
	public static void main(String args[]) throws IOException {
		numSquares(12);
	}
	
	public static int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i-(j*j) >= 0) {
                min = Math.min(min, dp[i-(j*j)]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
	
	private static Set<String> fetchProblemSet(String fileName) throws IOException {
		Set<String> results = new HashSet<>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String splits [] = line.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < splits.length - 2; i++) {
				sb.append(" " + splits[i]);
			}
			results.add(sb.toString().trim());
		}
		return results;
	}
}
