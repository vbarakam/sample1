package com.yahoo.util.dynamic;

public class BooleanParenthesizationProblem {
	public static void main(String args[]) {
		 String symbols = "TTFT";
		 String operators = "|&^";
		 String symbols1 = "TFF";
		 String operators1 = "^|";
		 int val = paren(symbols, operators, symbols.length());
		 if (val != 4) {
			 System.out.println("ERROR");
		 } else {
			 System.out.println("SUCESS");
		 }
	}

	private static int paren(String symbols, String operators, int n) {
	}
}
