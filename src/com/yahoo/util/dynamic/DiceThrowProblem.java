package com.yahoo.util.dynamic;

public class DiceThrowProblem {
	int count = 0;
	
	public static void main(String args[]) {
		/*cout << findWays(4, 2, 1) << endl;
	    cout << findWays(2, 2, 3) << endl;
	    cout << findWays(6, 3, 8) << endl;
	    cout << findWays(4, 2, 5) << endl;
	    cout << findWays(4, 3, 5) << endl;*/
		DiceThrowProblem problem = new DiceThrowProblem();
		//problem.findWays(4, 2, 0, 1);
		problem = new DiceThrowProblem();
		problem.findWays(6, 3, 0, 8);
		problem = new DiceThrowProblem();
		problem.findWays(4, 3, 0, 5);
		System.out.println(problem.count);
	}
	
	private void findWays(int faces, int n, int currentSum, int target ) {
		//System.out.println(n + " " + currentSum);
		if (n == 0 && currentSum == target) {
			count++;
		}
		
		if (n == 0 || currentSum > target) {
			return;
		}
		for (int i = 1; i <= faces; i++) {
			if (currentSum+i <= target) {
				findWays(faces, n-1, currentSum+i, target);
			}
		}
	}
}
