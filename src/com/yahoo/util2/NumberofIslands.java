package com.yahoo.util2;

public class NumberofIslands {
	public static void main(String args[]) {
		char data[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(data));
	}

	public static int numIslands(char[][] grid) {
		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && checkIsland(grid, i, j)) {
					counter++;
				}
			}
		}
		return counter;
	}

	private static boolean checkIsland(char[][] grid, int i, int j) {
		if (grid[i][j] == '1') {
			int zeros = 0;
			int onces = 0;
			if (i == 0) {
				zeros++;
			} else if (i > 0) {
				if (grid[i - 1][j] == '0') {
					zeros++;
				} else {
					onces++;
				}
			}

			if (i == grid.length - 1) {
				zeros++;
			} else if (i < grid.length) {
				if (grid[i + 1][j] == '0') {
					zeros++;
				} else {
					onces++;
				}
			}

			if (j == 0) {
				zeros++;
			} else if (j > 0) {
				if (grid[i][j-1] == '0') {
					zeros++;
				} else {
					onces++;
				}
			}

			if (j == grid[0].length - 1) {
				zeros++;
			} else if (i < grid[0].length) {
				if (grid[i][j + 1] == '0') {
					zeros++;
				} else {
					onces++;
				}
			}

			return (onces == 1 && zeros == 3) ? true : false;
		}
		return false;
	}
}
