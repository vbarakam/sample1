package com.yahoo.util.trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public String toString() {
		return "V " + val + " L " + right + " R "  + left;
	}
}