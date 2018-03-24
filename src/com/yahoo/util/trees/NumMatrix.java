package com.yahoo.util.trees;

class NumMatrix {
    private int data[][];
    private int tree[][];
    private int m = 0;
    private int n = 0;

    public static void main(String args[]) {
    	String str = "ba";
    	for (int i = 0; i < str.length() -1;i++) {
    		System.out.println(str.charAt(i)-str.charAt(i+1));
    	}
    }
    
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return;
        }
        n = matrix[0].length;
        data = new int[m][n];
        tree = new int[m+1][n+1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) {
            return;
        }
        int diff = val - data[row][col];
        data[row][col] = val;
        for (int i = row + 1; i <= m; i += i&-i) {
            for (int j = col + 1; j <= n; j += j&-j) {
                tree[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return sum(row1, col1) + sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
    
    private int sum(int row1, int col1){
        int sum = 0;
        for (int i =  row1; i > 0; i -= i & -i) {
            for (int j =  col1; j > 0; j -= j & -j) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
