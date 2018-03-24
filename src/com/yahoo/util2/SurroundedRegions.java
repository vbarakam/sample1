package com.yahoo.util2;

public class SurroundedRegions {
	
	public static void main(String args[]) {
		char data[][] = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}};
		char data2[][] = { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O','X', 'O', 'X', 'O', 'X' } };
		//solve2(data);
		char d = 2;
		System.out.println(" :: " + d);
		int d1 =2;
		System.out.println(d1);
	}

	public static void solve2(char[][] board) {
        if (board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                check2(board, i, 0, m, n);
            }
            
            if (board[i][n-1] == 'O') {
                check2(board, i, n-1, m, n);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                check2(board, 0, i, m, n);
            }
            
            if (board[m-1][i] == 'O') {
                check2(board, m-1, i, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private static void check2(char[][] board, int row, int col, int rowMax, int colMax) {
        if (row < 0 || col < 0 || row == rowMax || col == colMax || board[row][col] == 'X') {
            return;
        }
        
        if (board[row][col] == 'O') {
            board[row][col] = '1';
            check2(board, row+1, col, rowMax, colMax);
            check2(board, row-1, col, rowMax, colMax);
            check2(board, row, col-1, rowMax, colMax);
            check2(board, row, col+1, rowMax, colMax);
        }
    }
    
	public static void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}

		if (board.length < 2 || board[0].length < 2)
			return;

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}

			if (board[i][board[0].length - 1] == 'O') {
				dfs(board, i, board[0].length - 1);
			}
		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}

			if (board[board.length - 1][i] == 'O') {
				dfs(board, board.length - 1, i);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private static void dfs(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
			return;
		}

		if (board[i][j] == 'O') {
			board[i][j] = '*';
		}

		if (i > 1 && board[i - 1][j] == 'O') {
			dfs(board, i - 1, j);
		}

		if (i < board.length - 2 && board[i + 1][j] == 'O') {
			dfs(board, i + 1, j);
		}

		if (j > 1 && board[i][j - 1] == 'O') {
			dfs(board, i, j - 1);
		}

		if (j < board[i].length - 2 && board[i][j + 1] == 'O') {
			dfs(board, i, j + 1);
		}
	}
}
