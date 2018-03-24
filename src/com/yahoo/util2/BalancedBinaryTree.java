package com.yahoo.util2;

public class BalancedBinaryTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int diff = balanced(root);
        return diff == -1 ? false : true; 
    }
    
    private static int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = balanced(root.left);
        if (left == -1) {
            return -1;
        }
        int right = balanced(root.right);
        if (left == -1) {
            return -1;
        }
        
        if (Math.abs(left-right) > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}
