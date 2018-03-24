package com.yahoo.util;

import java.util.*;

public class RotateImage {
	public static void main(String args[]) {
		int[][] pp = {{1,2},{3,4}};
		List<List<Integer>> results = new ArrayList<>();
		rotate(pp);
		
	}
	
	
	public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
