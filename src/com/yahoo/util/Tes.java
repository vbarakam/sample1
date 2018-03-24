package com.yahoo.util;

import java.util.Stack;
import java.util.TreeSet;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Tes {
	public static void main(String args []) {
		String str1 = "aa";
		String str2 = "a*";
		System.out.print(isMatch(str1, str2));
	}
	
	public static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        
        TreeSet<Long> data = new TreeSet<>();
        
        for (int i = 0; i < nums.length; ++i) {
            
            Long floor = data.floor((long)nums[i]+t);
            Long ceil = data.ceiling((long)nums[i]-t);
            
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i] )) {
                return true;
            }
            data.add((long)nums[i]);
            if (i -k >= 0) {
                data.remove((long)nums[i - k]) ;
            }
        }
        return false;
    }    
	
	public static int slidingPuzzle(int[][] board) {
        int zero_r = 0;
        int zero_c = 0;
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0) {
                    zero_r = i;
                    zero_c = j;
                    break;
                }
            }
        }
        Queue<NNode> queue = new ArrayDeque<>();
        String target = Arrays.deepToString(new int[][]{{1,2,3},{4,5,0}});
        int directions[][] = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        NNode start = new NNode(board, zero_r, zero_c, 0);
        Set<String> seen = new HashSet<>();                  
        queue.add(start);
        
        while (!queue.isEmpty()) {
        	NNode node = queue.poll();
            
            if (node.boardstring.equals(target)) {
                return node.depth;
            }
            
            for (int direction[] : directions) {
                int new_r = node.row + direction[0];
                int new_c = node.col + direction[1];
                if ( new_r < 0 || new_r >= r || new_c < 0 || new_c >= c) {
                    continue;
                }
                int [][] newboard = new int[r][c];
                int t = 0;
                for (int row[] : node.board) {
                    newboard[t++] = row.clone();
                }
                newboard[node.row][node.col] = node.board[new_r][new_c];
                newboard[new_r][new_c] = 0;
                NNode nextNode = new NNode(newboard, new_r, new_c, node.depth+1);
                System.out.println(nextNode.boardstring);
                if (seen.contains(nextNode.boardstring)) {
                    continue;
                }
                
                seen.add(nextNode.boardstring);
                queue.offer(nextNode);
            }
            
        }
        return -1;
    }
	
	
	private static int compute(String str) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                num = ch - '0';
            } else if (ch == '+' || ch == '-' || ch == '*' || i == str.length()-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                }
                num = 0;
                sign = ch;
            }
        }
        if (sign == '+') {
            stack.push(num);
        } else if (sign == '-') {
            stack.push(-num);
        } else if (sign == '*') {
            stack.push(stack.pop()*num);
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

class NNode {
    int[][] board;
    int row;
    int col;
    String boardstring;
    int depth;
    
    public NNode(int[][] board, int row, int col, int depth) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.depth = depth;
        boardstring = Arrays.deepToString(board);
    }
}
