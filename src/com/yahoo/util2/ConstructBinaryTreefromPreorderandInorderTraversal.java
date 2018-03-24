package com.yahoo.util2;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static void main(String args[]) {
		//int [] preOrder = {1,2,4,5,3,6,7};
		//int [] inOrder = {4,2,5,1,6,3,7};
		
		int [] preOrder = {1,2};
		int [] inOrder = {1,2};
		
		TreeNode tree = process(preOrder, inOrder, 0, 0, inOrder.length-1);
		System.out.println(tree.val);
	}
	
	private static TreeNode process(int preOrder[], int inOrder [], int preStart, int inStart, int inEnd) {
		if (preStart > preOrder.length -1 || inStart > inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(preOrder[preStart]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inOrder[i] ) {
				inIndex = i;
			}
		}
		
		root.left = process(preOrder, inOrder, preStart + 1, inStart, inIndex-1);
		root.right = process(preOrder, inOrder,preStart +inIndex - inStart +1, inIndex +1,inEnd);
		
		return root;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}