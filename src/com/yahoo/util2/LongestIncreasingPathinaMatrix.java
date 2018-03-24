package com.yahoo.util2;

public class LongestIncreasingPathinaMatrix {
	private static int dirs[][] = {{0,-1},{0,+1},{-1,0},{1,0}};
	
	public static void main3(String args[]) {
		int nums[][] = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}};
		//System.out.println(longestIncreasingPath(nums));
		System.out.println(divide(15,2));
	}
	
	public static int divide(int dividend, int divisor) {
        if (dividend == 0 || dividend < divisor) {
            return 0;
        }
        
        
        int sum = divisor;
        int index = 1;
        while (sum + sum < dividend) {
            sum += sum;
            index += index;
        }
        return index;
    }
	
	public static void main(String args[]) {
		int nums1[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		int nums2[][] = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		int[][] cache = new int[nums1.length][nums1[0].length];
		
		System.out.println(longestIncreasingPath2(nums2));
	}
	
	public static int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int max = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int score = compute2(matrix, i, j, cache);
                max = Math.max(max, score);
            }
        }
        return max;
    }
    
    private static int compute2(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        if (i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            int score = compute2(matrix, i-1, j, cache);
            cache[i][j] = Math.max(cache[i][j], score);
        }
        
        if (i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            int score = compute2(matrix, i+1, j, cache);
            cache[i][j] = Math.max(cache[i][j], score);
        }
        
        if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
            int score = compute2(matrix, i, j-1, cache);
            cache[i][j] = Math.max(cache[i][j], score);
        }
        
        if (j + 1 < matrix[i].length && matrix[i][j+1] > matrix[i][j]) {
            int score = compute2(matrix, i, j+1, cache);
            cache[i][j] = Math.max(cache[i][j], score);
        }
        return ++cache[i][j];
    }
	
	public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, explore(matrix, i, j));
            }
        }
        
        return max + 1;
    }
    
    private static int explore(int[][] matrix, int i, int j) {
        int max = 0;
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return max;
        }
        
        if (i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + explore(matrix, i-1,j));
        }
        
        if (i+1 < matrix.length && matrix[i+1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + explore(matrix, i+1,j));
        }
        
         if (j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
            max = Math.max(max, 1 + explore(matrix, i,j-1));
        }
        
        if (j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]) {
            max = Math.max(max, 1 + explore(matrix, i,j+1));
        }
        
        return max;
    }

	private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
		if (cache[i][j] != 0) {
			return cache[i][j];
		}
		
		int max = 0;
		for (int[] temp : dirs) {
			int x = temp[0], y = temp[1];
			int x1 = i + x;
			int y1 = j + y;
			if (x1 >= 0 && x1 < matrix.length && y1 >= 0 && y1 < matrix[0].length) {
				if (matrix[x1][y1] > matrix[i][j]) {
					int max2 = 1 + dfs(matrix, x1, y1, cache);
					max = Math.max(max, max2);
				}
			} else {
				continue;
			}
		}
		
		cache[i][j] = max;
		return max;
	}
}
