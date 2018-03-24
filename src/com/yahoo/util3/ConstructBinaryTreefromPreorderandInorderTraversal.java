package com.yahoo.util3;

import com.yahoo.util.trees.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static void main(String args[]) {
		int data[] = {-1};
		
		int pre[] = {3,1,2,4};
		int in[] =	{1,2,3,4};
		buildTree(pre, in);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, 0, inorder.length -1);
    }
    
    private static TreeNode build(int[] preorder, int[] inorder, int preBegin, int inBegin, int inEnd) {
        if (preBegin >= preorder.length || inBegin > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == preorder[preBegin]) {
                rootIndex = i;
            }
        }
        root.left = build(preorder, inorder, preBegin + 1, inBegin, rootIndex -1);
        root.right = build(preorder, inorder, preBegin + rootIndex - inBegin +1, rootIndex+1, inEnd);
        System.out.println((preBegin + rootIndex - inBegin +1) + ":: w");
        System.out.println( (rootIndex+1) + ":: n");
        //root.right = build(preorder, inorder, rootIndex+1, rootIndex+1, inEnd);
        
        return root;
    }
}
