package com.yahoo.util2;

import com.yahoo.util.trees.TreeNode;
import java.util.*;

public class PathSumIII {
	int count = 0;
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		
		PathSumIII sum = new PathSumIII();
		sum.pathSum(root, 8);
	}
	
	public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        preprocess(root, 0, sum, preSum);
        return count;    
    }
    
    private void preprocess(TreeNode root, int currSum, int sum, Map<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }
        
        currSum += root.val;
        if (preSum.containsKey(currSum-sum)) {
            count += preSum.get(currSum-sum); 
        }
        
        preSum.put(currSum, preSum.getOrDefault(currSum,0) + 1);
        
        preprocess(root.left, currSum, sum, preSum);
        preprocess(root.right, currSum, sum, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }
}

