package com.yahoo.util.dynamic;

public class OptimalStrategyGame {
	static class Pair {
		int first, second;
		int pos = 0;

		public String toString() {
			return "( " + first + ", " + second + ", " + pos + " )";
		}
	}

	public static void main(String args[]) {
		int pots[] = { 3, 1, 5, 6, 2, 9, 3 };
		// int pots[] = {3,9,1,2};
		OptimalStrategyGame game = new OptimalStrategyGame();
		Pair[][] moves = game.findMoves2(pots);
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				System.out.print(moves[i][j] + "  ");
			}
			System.out.print("\n");
		}
		System.out.println("The moves by first player and second player:");
		game.printSequence(pots, moves);
	}

	public Pair[][] findMoves2(int pots[]) {

		Pair[][] moves = new Pair[pots.length][pots.length];

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				moves[i][j] = new Pair();
			}
		}

		for (int i = 0; i < pots.length; i++) {
			moves[i][i].first = pots[i];
			// to track the sequence of moves
			moves[i][i].pos = i;
		}

		for (int l = 2; l <= pots.length; l++) {
			for (int i = 0; i <= pots.length - l; i++) {
				int j = i + l - 1;
				System.out.println(i + " => " + j);
				if (pots[i] + moves[i + 1][j].second > moves[i][j - 1].second + pots[j]) {
					moves[i][j].first = pots[i] + moves[i + 1][j].second;
					moves[i][j].second = moves[i + 1][j].first;
					moves[i][j].pos = i;
				} else {
					moves[i][j].first = pots[j] + moves[i][j - 1].second;
					moves[i][j].second = moves[i][j - 1].first;
					moves[i][j].pos = j;
				}
			}
		}

		return moves;
	}

	// 3 9 1 2
	public Pair[][] findMoves(int pots[]) {
		Pair dp[][] = new Pair[pots.length][pots.length];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = new Pair();
			}
		}

		for (int i = 0; i < pots.length; i++) {
			dp[i][i].first = pots[i];
			dp[i][i].pos = i;
		}

		for (int l = 2; l <= pots.length; l++) {
			for (int i = 0; i <= pots.length - l; i++) {
				int j = i + l - 1;
				if (pots[i] + dp[i + 1][j].second > pots[j] + dp[i][j - 1].second) {
					dp[i][j].first = pots[i] + dp[i + 1][j].second;
					dp[i][j].second = dp[i + 1][j].first;
					dp[i][j].pos = i;
				} else {
					dp[i][j].first = pots[j] + dp[i][j - 1].second;
					dp[i][j].second = dp[i][j - 1].first;
					dp[i][j].pos = j;
				}
			}
		}
		return dp;
	}

	// prints the sequence of values and indexes
	public void printSequence(int pots[], Pair moves[][]) {
		int i = 0;
		int j = pots.length - 1;
		int step;
		for (int k = 0; k < pots.length; k++) {
			step = moves[i][j].pos;
			System.out.println("value: " + pots[step] + " " + "index: " + step + " ");
			if (step <= i) {
				i = i + 1;
			} else {
				j = j - 1;
			}
		}
	}
}
