package com.yahoo.util3;

public class TextJustification {
	public static void main(String args[]) {
		String words1[] = {"Tushar","likes","to","write","code","at", "free", "time"};
		String words[] = {"Tushar","roy","likes","to","code"};
		System.out.println(justify2(words, 10));
	}
	
	public static String justify2(String words[], int width) {

		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < words.length; i++) {
			if (i != 0 && pos[i] == pos[i-1]) {
				continue;
			}
			for (int j = i; j < pos[i]; j++) {
				sb.append(words[j]);
				if (j != pos[i] -1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String justify(String words[], int width) {
		int cost[][] = new int[words.length][words.length];
		for (int i = 0; i < words.length; i++) {
			cost[i][i] = width - words[i].length();
			for (int j = i+1; j < words.length; j++) {
				cost[i][j] = cost[i][j-1] - 1 - words[j].length();
			}
		}
		
		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}
		int fc[] = new int[words.length];
		int result[] = new int[words.length];
		
		for (int i = words.length -1; i >= 0; i--) {
			fc[i] = cost[i][words.length -1];
			result[i] = words.length;
			for (int j = words.length -1; j > i; j--) {
				if (cost[i][j-1] == Integer.MAX_VALUE) {
					continue;
				}
				if (fc[i] > (fc[j] + cost[i][j-1])) {
					fc[i] = fc[j] + cost[i][j-1];
					result[i] = j;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (i != 0 && result[i] == result[i-1] ) {
				continue;
			}
			for (int j = i; j < result[i]; j++) {
				sb.append(words[j]);
				if (j != result[i] -1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
