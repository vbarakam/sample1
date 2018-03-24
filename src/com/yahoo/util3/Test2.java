package com.yahoo.util3;

import java.util.*;

public class Test2 {
	public static void main(String args[]) {
		int data[] = {100, 4, 200, 1, 3, 2};
		longestConsecutive(data);
	}
	
	public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {            
                int right = map.getOrDefault(num + 1, 0);
                int left = map.getOrDefault(num - 1, 0);
                int sum = right + left + 1;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num + right, sum);
                map.put(num - left, sum);
            }
        }
        return max;
    }
	
	public static void main2(String args []) {
		int matrix[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };

        int max = 0;
        int cache[][] = new int[matrix.length][matrix[0].length];
        Map<String, List<Integer>> paths = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
            	paths.put(i+"-"+j, new ArrayList<>());
            	paths.get(i+"-"+j).add(matrix[i][j]);
                max = Math.max(max, process(matrix, i, j, cache, paths, i+"-"+j));
            }
        }
        
        int maxRow = 0;
        int maxCol = 0;
        int max2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
            	if (cache[i][j] > max2) {
            		max2 = cache[i][j];
            		maxRow = i;
            		maxCol = j;
            	}
            }
        }
        List<Integer> pats = new ArrayList<>();
        pats.add(matrix[maxRow][maxCol]);
        while (cache[maxRow][maxCol] != 1) {
        	if (maxRow-1 >= 0 && cache[maxRow-1][maxCol] + 1 == cache[maxRow][maxCol]) {
        		maxRow = maxRow -1;
        		pats.add(matrix[maxRow][maxCol]);
        	} else if (maxRow+1 < matrix.length && cache[maxRow+1][maxCol] + 1 == cache[maxRow][maxCol]) {
        		maxRow = maxRow +1;
        		pats.add(matrix[maxRow][maxCol]);
        	} else if (maxCol-1 >= 0 && cache[maxRow][maxCol-1] + 1 == cache[maxRow][maxCol]) {
        		maxCol = maxCol -1;
        		pats.add(matrix[maxRow][maxCol]);
        	} else if (maxCol+1 < matrix[0].length && cache[maxRow][maxCol+1] + 1 == cache[maxRow][maxCol]) {
        		maxCol = maxCol +1;
        		pats.add(matrix[maxRow][maxCol]);
        	}
        }
        //pats.add(matrix[maxRow][maxCol]);
        System.out.println(pats);
        
	}
	
	private static int process(int[][] matrix, int i, int j, int cache[][], Map<String, List<Integer>> paths, String path ) {
        if (cache[i][j] != 0) {
        	if (paths.getOrDefault(i+"-"+j, new ArrayList<>()).size() > 0) {
        		paths.get(path).addAll(paths.getOrDefault(i+"-"+j, new ArrayList<>()));
        	}
            return cache[i][j];
        }
        
        if (i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) {
        	paths.get(path).add(matrix[i-1][j]);
            cache[i][j] = Math.max(cache[i][j], process(matrix, i-1, j, cache, paths, path));
        }
        
        if (i+1 < matrix.length &&  matrix[i+1][j] > matrix[i][j]) {
        	paths.get(path).add(matrix[i+1][j]);
            cache[i][j] = Math.max(cache[i][j], process(matrix, i+1, j, cache, paths, path));
        }
        
        if (j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
        	paths.get(path).add(matrix[i][j-1]);
            cache[i][j] = Math.max(cache[i][j], process(matrix, i, j-1, cache, paths, path));
        }
        
        if (j+1 < matrix[0].length &&  matrix[i][j+1] > matrix[i][j]) {
        	paths.get(path).add(matrix[i][j+1]);
            cache[i][j] = Math.max(cache[i][j], process(matrix, i, j+1, cache, paths, path));
        }
        
        return ++cache[i][j];
    }
}
