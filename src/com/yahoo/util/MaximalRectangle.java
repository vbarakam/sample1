package com.yahoo.util;

public class MaximalRectangle {
	public static void main(String args[]) {
		char result[][] = { {'1', '0', '1', '0', '0'},
				            {'1', '0', '1', '1', '1'},
				            {'1', '1', '1', '1', '1'},
				            {'1', '0', '0', '1', '0'}};
		System.out.println(maximalRectangle(result));
	}
	
	public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int r[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0;i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    r[i][j] = 1;
                }
                
                if (matrix[i][j] == '1' && ((i -1 >= 0) && (j -1 >= 0) && matrix[i-1][j-1] == '1') && 
                    ((i -1 >= 0) && matrix[i-1][j] == '1') && 
                    ((j -1 >= 0) && matrix[i][j-1] == '1')) {
                    r[i][j] += r[i-1][j-1] + r[i-1][j] + r[i][j-1];
                    if (r[i][j] > max) {
                        max = r[i][j];
                    }
                }
                
                
            }
        }
        return max;
    }
}
