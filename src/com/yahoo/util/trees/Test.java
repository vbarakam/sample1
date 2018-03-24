package com.yahoo.util.trees;

public class Test {
	public static void main(String args[]) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int w[] = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			update(w, i, a[i]);
		}
		/*cStart(2);
		cStart(3);
		cStart(4);
		cStart(5);
		cStart(6);
		cStart(7);
		cStart(8);
		cStart(9);
		cStart(10);
		cStart(11);*/
		//cStart(0b1110);
		cStart(0b1010);
		//up(15);

	}
	
	private static void update(int w[], int i, int val) {
		for (; i <=w.length; i += i&(-i)) {
			w[i] += val;
		}
	}
	
	private int search(int w[], int i) {
		return -1;
	}
	
	private static int cStart(int index) {
		System.out.println(Integer.toBinaryString(index));
		System.out.println(Integer.toBinaryString(-index));
		int r = index & -index;
		System.out.println(" ::: " + r);
		int start = index - (1<<r) + 1;
		System.out.println(start + " to " + index);
		return start;
	}
	
	private static void up(int i) {
		StringBuilder sb = new StringBuilder();
		for (; i > 0; i -= (i & (-i))) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(i);
		}
		System.out.println(sb.toString());
	}
	
	private static void down(int i) {
		StringBuilder sb = new StringBuilder();
		for (; i < i; i += i & (-i)) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(i);
			
			
		}
	}
}
