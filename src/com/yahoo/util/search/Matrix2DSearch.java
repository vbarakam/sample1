package com.yahoo.util.search;

public class Matrix2DSearch {
	public static void main(String args[]) {
		int input1 [][] = {{1,1}};
		int input2 [][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(input1, 2));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        
        if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == target) {
            return true;
        }
        
        int start = 0;
        int end = matrix[0].length * matrix.length - 1;
        int col = matrix[0].length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            
            if (matrix[mid/col][mid%col] == target) {
                return true;
            } else if (target < matrix[mid/col][mid%col]) {
                end = mid - 1;
            } else {
            	
                start = mid + 1;
            }
        }
        
        return false;
    }
}
