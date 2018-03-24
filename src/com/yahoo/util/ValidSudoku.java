package com.yahoo.util;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String args[]) {
		char[][] board = new char[10][10];
		isValidSudoku(board);
	}
	
	 public static boolean isValidSudoku(char[][] board) {
	        for(int i = 0; i<9; i++){
		        HashSet<Character> rows = new HashSet<Character>();
		        HashSet<Character> columns = new HashSet<Character>();
		        HashSet<Character> cube = new HashSet<Character>();
		        for (int j = 0; j < 9;j++){
		            if (board[i][j] != '.' && !rows.add(board[i][j])) {
		                return false;
		            }
		            
		            if (board[j][i] != '.' && !rows.add(board[j][i])) {
		                return false;
		            }
		            
		            int rowIndex = 3 * (i/3);
		            int colIndex = 3 * (i%3);
		            if (board[rowIndex + (j/3)][colIndex + (j % 3)] != '.' 
		                    && !cube.add(board[rowIndex + (j/3)][colIndex + (j%3)])) {
		                return false;
		                
		            }
		        }
	        }
	        return true;
	    }
}
