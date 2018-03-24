package com.yahoo.util.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String args[]) {
		int m[][] = {{2,3}};
		int[] nums = new int[10];
		Arrays.asList(nums);
		int m1[][] = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		System.out.println(spiralOrder2(m));
	}
	
	public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0) {
            return results;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                results.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            for (int i = rowBegin; i <= rowEnd; i++) {
                results.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
            	for (int i = colEnd; i >= colBegin; i--) {
            		results.add(matrix[rowEnd][i]);
            	}
            	rowEnd--;
            }
            if (colBegin <= colEnd) {
	            for (int i = rowEnd; i >= rowBegin; i--) {
	                results.add(matrix[i][colBegin]);
	            }
	            colBegin++;
            }
        }
        return results;
    }
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        
        int rowBegin = 0;
        int columnBegin = 0;
        int rowEnd = matrix.length;
        int columnEnd = matrix[0].length;
        while (rowBegin < rowEnd && columnBegin < columnEnd) {
            
            // traverse right
            for (int c = columnBegin; c < columnEnd && rowBegin != rowEnd; c++) {
                result.add(matrix[rowBegin][c]);
            }
            rowBegin += 1;
            
            // traverse down
            for (int r = rowBegin; r < rowEnd && columnBegin != columnEnd; r++) {
                result.add(matrix[r][columnEnd-1]);
            }
            columnEnd -= 1;
            
            // traverse back
            for (int c = columnEnd -1; c >= columnBegin && rowBegin != rowEnd; c--) {
                result.add(matrix[rowEnd-1][c]);
            }
            rowEnd -= 1;
            
            // traverse up
            for (int r = rowEnd - 1; r >= rowBegin && columnBegin != columnEnd; r--) {
                result.add(matrix[r][columnBegin]);
            }
            columnBegin += 1;
        }
        
        return result;
    }
}
