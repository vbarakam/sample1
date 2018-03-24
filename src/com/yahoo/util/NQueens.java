package com.yahoo.util;

import java.util.*;

public class NQueens {

	public static void main(String args[]) {
		System.out.println(solveNQueens(5));
	}
	
	public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> results = new ArrayList<>();
        queens(n, 0, board, results);
        return results;
    }
    
    private static void  queens(int n, int currentRow, char[][] board, List<List<String>> results) {
        if (currentRow == n) {
            List<String> result = new ArrayList<>();
            for (char[] row : board) {
                StringBuilder sb = new StringBuilder();
                for (char column : row) {
                    if (column == 'Q') {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                result.add(sb.toString());
            }
            results.add(result);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (validate(board, currentRow, i)) {
                board[currentRow][i] = 'Q';
                queens(n, currentRow+1, board, results);
                board[currentRow][i] = '.';
            }
        }        
    }
    
    private static boolean validate(char[][] board, int rIndex, int cIndex) {
        for (int i = 0; i < board.length; i++) {
        	
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'Q' && (i == rIndex || j == cIndex)) {
        			return false;
        		}
        	}
        }
    	// row above
        if ((rIndex == 0 || board[rIndex-1][cIndex] != 'Q')  &&
        		(rIndex == 0 || cIndex == 0 || board[rIndex-1][cIndex-1] != 'Q' ) &&
        		( rIndex == 0 || cIndex == board.length -1 || board[rIndex-1][cIndex+1] != 'Q')) {
            
        
        if ((rIndex == board.length -1 || board[rIndex+1][cIndex] != 'Q') &&
        		(rIndex == board.length -1 || cIndex == 0 || board[rIndex+1][cIndex-1] != 'Q') &&
        		(rIndex == board.length -1 || cIndex == board.length -1 || board[rIndex+1][cIndex+1] != 'Q')) {
            return true;  
        }
        }
        return false;
    }
	
	public static void main2(String args[]) {
		List<Position> queens = new ArrayList<>();
		List<List<Position>> results = new ArrayList<>();
		
		int col = 0;
		while (col < 3) {
			nqueens(0, col, 3, queens, results);
			if (queens.size() > 0) {
				col = queens.get(0).col + 1;
			} else 
				break;
			System.out.println(queens);
			queens.clear();

		}
		
		//System.out.println(results);
	}
	
	public static boolean nqueens(int row, int icol, int n, List<Position> queens, List<List<Position>> results) {
		// base condition
		if (row == n) {
			results.add(queens);
			return true;
		}
		
		for (int col = icol; col < n; col ++) {
			// check if the conditions satisfy
			boolean result = true;
			for (Position pos : queens) {
				if (pos.row == row || pos.col == col || 
						(row - col) == (pos.row - pos.col) || (row + col) == (pos.row + pos.col)) {
					result = false;
					break;
					
				}
			}
			
			if (result) {
				// if row and col is good, check next rows
				Position pos = new Position(row, col);
				queens.add(pos);
				if (nqueens(row +1, 0, n, queens, results)) {
					return true;
				} else {
					queens.remove(pos);
				}
			}
		}
		
		return false;
	}
	
	static class Position {
		int row;
		int col;
		
		public Position(int r, int c) {
			this.row = r;
			this.col = c;
		}
		
		public String toString() {
			return " Row : " + this.row + " Column : " + this.col;
		}
	}
}
