package com.yahoo.util3;

public class BooleanParenthesizationProblem2 {
	public static void main(String args[]) {
		String symbols = "TTFT";
	    String operators = "|&^";
	    int val = parenthesization(symbols, operators);
	    if (val != 4) {
	    	System.out.println(val);
	    	System.out.println("Error");
	    } else {
	    	System.out.println("Sucess");
	    }
	} 
	
	private static int parenthesization(String pattern, String symbols) {
		int n = pattern.length();
		int T[][] = new int[n][n];
		
		return T[0][n-1];
	}
}
