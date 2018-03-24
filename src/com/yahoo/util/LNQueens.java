package com.yahoo.util;

import java.util.*;

public class LNQueens {

	public static void main(String args[]) {
		System.out.println(solveNQueens(5).size());
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> results = new ArrayList<>();

		if (n < 3) {
			return results;
		}

		List<String> result = new ArrayList<>();

		List<Position> points = new ArrayList<>();
		List<List<Position>> results2 = new ArrayList<>();
		nqueens(0, 0, n, points, results2);
		if (results2.size() > 0) {
			for (List<Position> positions2 : results2) {
				
			}
				for (int row = 0; row < n; row++) {
					Position pos = positions2.get(row);
					StringBuilder b = new StringBuilder();
					for (int col2 = 0; col2 < n; col2++) {
						if (col2 == pos.col) {
							b.append("Q");
						} else {
							b.append(".");
						}
					}
					result.add(b.toString());
				}
			results.add(result);
		}
		return results;
	}

	public static boolean nqueens(Integer row, int icol, int n, List<Position> positions,
			List<List<Position>> results) {
		if (row == n) {
			List<Position> temp = new ArrayList<>();
			temp.addAll(positions);
			results.add(temp);
			return true;
		}

		boolean dresult = false;
		for (int col = icol; col < n; col++) {
			boolean result = true;
			for (Position pos : positions) {
				if (row == pos.row || col == pos.col || (row - col) == (pos.row - pos.col)
						|| (row + col) == (pos.row + pos.col)) {
					result = false;
					break;
				}
			}
			if (result) {
				Position pos = new Position(row, col);
				positions.add(pos);
				if (nqueens(row + 1, 0, n, positions, results)) {
					dresult = dresult || true;
					positions.remove(pos);
				} else {
					positions.remove(pos);
				}

			}
		}
		return dresult;
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
