package com.yahoo.util3;

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
		int T[][] = new int[n][n]; int F[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			if (symbols.charAt(i) == 'T') {
				T[i][i] = 1;
			}
			if (symbols.charAt(i) == 'F') {
				F[i][i] = 1;
			}
		}
		
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0, j =  i + gap; j < n && i < n; j++,i++) {
				T[i][j] = 0; F[i][j] = 0;
				for (int g = 0; g < gap; g++) {
					int k = i+g;
					int tt = T[i][k] + F[i][k];
					int tf =  T[k+1][j] + F[k+1][j];;
					if (operators.charAt(k) == '&') {
						T[i][j] += T[i][k] * T[k+1][j];
						F[i][j] +=  tt*tf - T[i][k] * T[k+1][j];
					} else if (operators.charAt(k) == '|') {
						T[i][j] += (tt*tf) - F[i][k] * F[k+1][j];;
						F[i][j] += F[i][k] * F[k+1][j];
					} else if (operators.charAt(k) == '^') {
						T[i][j] += T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j];
						F[i][j] += T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j];
					}
				}
			}
		}
		
		return T[0][n-1];
	}
}
