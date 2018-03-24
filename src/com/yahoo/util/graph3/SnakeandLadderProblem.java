package com.yahoo.util.graph3;

import java.util.*;

public class SnakeandLadderProblem {

	public int getMinDiceThrows(int moves[], int n) {
		boolean visited [] = new boolean[n];
		Queue<QEntry> queue = new LinkedList<>();
		visited[0] = true;
		queue.add(new QEntry(0,0));
		while (!queue.isEmpty()) {
			QEntry entry = queue.poll();
			if (entry.vertex == n-1) {
				return entry.distance;
			}
			int max = entry.vertex + 6;
			for (int i = entry.vertex + 1; i <= max && i < n; i++) {
				//if (!visited[i]) {
					visited[i] = true;
					QEntry nentry = new QEntry(moves[i] == -1 ? i : moves[i], entry.distance + 1);
					queue.add(nentry);
				//}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int N = 30;
		int moves[] = new int[30];
		for (int i = 0; i < N; i++)
			moves[i] = -1;
		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;
		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
		SnakeandLadderProblem game = new SnakeandLadderProblem();
		System.out.println("Min Dice throws required is " + game.getMinDiceThrows(moves, N));
	}
}

class QEntry {
	int vertex;
	int distance;

	public QEntry() {
		vertex = 0;
		distance = 0;
	}

	public QEntry(int v, int d) {
		vertex = v;
		distance = d;
	}
}
