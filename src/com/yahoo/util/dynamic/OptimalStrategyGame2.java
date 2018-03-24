package com.yahoo.util.dynamic;

public class OptimalStrategyGame2 {
	static class Pair {
		int first, second;
		int pos = 0;
		int parent = 0;

		public String toString() {
			return "( " + first + ", " + second + ", " + pos + " )";
		}
	}

	public static void main(String args[]) {
		int pots[] = { 3, 1, 5, 6, 2, 9, 3 };
		int pots1[] = { 3, 9, 1, 2 };
		OptimalStrategyGame2 game = new OptimalStrategyGame2();
		Pair[][] moves = game.findMoves3(pots);
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				System.out.print(moves[i][j] + "  ");
			}
			System.out.print("\n");
		}
		System.out.println("The moves by first player and second player:");
		game.printSequence(pots, moves);
		
		if (moves[0][moves.length - 1].first != 13 || moves[0][moves.length - 1].second != 16
				|| moves[0][moves.length - 1].pos != 6) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESSs");
		}
		moves = game.findMoves3(pots1);
		if (moves[0][moves.length - 1].first != 11 || moves[0][moves.length - 1].second != 4
				|| moves[0][moves.length - 1].pos != 3) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCESSs");
		}
	}

	public Pair[][] findMoves3(int pots[]) {
		Pair[][] dp = new Pair[pots.length][pots.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = new Pair();
			}
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][i].first = pots[i];
			dp[i][i].pos = i;
		}
		
		for (int gap = 2; gap <= pots.length; gap++) {
			for (int i = 0; i <= pots.length-gap; i++) {
				int r = i + gap-1;
				if (pots[i] + dp[i+1][r].second > pots[r] + dp[i][r-1].second) {
					dp[i][r].first = dp[i+1][r].second + pots[i];
					dp[i][r].second = dp[i+1][r].first;
					dp[i][r].pos = i;
					//dp[i][r].parent = 
				} else {
					dp[i][r].first = dp[i][r-1].second + pots[r];
					dp[i][r].second = dp[i][r-1].first;
					dp[i][r].pos = r;
				}
			}
		}
		return dp;
	}
	public Pair[][] findMoves2(int pots[]) {
		Pair[][] dp = new Pair[pots.length][pots.length];
		for (int i = 0; i < pots.length; i++) {
			for (int j = 0; j < pots.length; j++) {
				dp[i][j] = new Pair();
			}
		}
		for (int i = 0; i < pots.length; i++) {
			dp[i][i].first = pots[i];
			dp[i][i].pos = i;		
		}
		int n = pots.length;
		for (int l = 2; l <= pots.length; l++) {
			for (int i = 0; i <= n-l; i++) {
				int j = i+l-1;
				if (pots[i] + dp[i+1][j].second > pots[j] + dp[i][j-1].second) {
					dp[i][j].first = pots[i] + dp[i+1][j].second;
					dp[i][j].second =  dp[i+1][j].first;
					dp[i][j].pos = i;
				} else {
					dp[i][j].first = pots[j] + dp[i][j-1].second;
					dp[i][j].second = dp[i][j-1].first;
					dp[i][j].pos = j;
				}
			}
		}

		return dp;
	}

	// prints the sequence of values and indexes
	public void printSequence(int pots[], Pair moves[][]) {
		int i = 0;
		int j = moves.length - 1;
		for (int k = 0; k < moves.length; k++) {
			int pos = moves[i][j].pos;
			System.out.println(" value = " + pots[pos] + " pos = " + pos);
			if (pos <= i) {
				i = i + 1;
			} else {
				j = j - 1;
			}
		}
	}
}
