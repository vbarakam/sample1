package com.yahoo.util3;

public class FlattenBinaryTreetoLinkedList {
	private TreeNode prev = null;
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		FlattenBinaryTreetoLinkedList tree = new FlattenBinaryTreetoLinkedList();
		tree.process(root);
		
	}
	
	private void process(TreeNode root) {
		if (root == null) {
			return;
		}
		process(root.right);
		process(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}
