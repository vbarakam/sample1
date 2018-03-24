package com.yahoo.util;

public class WordSearch {
	public static void main(String args[]) {
		char[][] c = {{'a','a'}};
		System.out.println(exist(c, "aaa"));
	}

	public static boolean exist(char[][] board, String word) {

		if (word == null || word.length() == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean status = process(board, i, j, word, 1);
					if (status) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean process(char[][] board, int row, int col, String word, int i) {
		if (i == word.length()) {
			return true;
		}

		// check up
		if ((row - 1) >= 0 && board[row - 1][col] == word.charAt(i)) {
			boolean status = process(board, row - 1, col, word, i + 1);
			if (status) {
				return true;
			}
		}

		// check down
		if ((row + 1) < board.length && board[row + 1][col] == word.charAt(i)) {
			boolean status = process(board, row + 1, col, word, i + 1);
			if (status) {
				return true;
			}
		}

		// check right
		if ((col + 1) < board[row].length && board[row][col + 1] == word.charAt(i)) {
			boolean status = process(board, row, col + 1, word, i + 1);
			if (status) {
				return true;
			}
		}

		// check left
		if ((col - 1) >= 0 && board[row][col - 1] == word.charAt(i)) {
			boolean status = process(board, row, col - 1, word, i + 1);
			if (status) {
				return true;
			}
		}

		// none of the above work, go to next point
		return false;
	}
}
