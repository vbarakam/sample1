package com.yahoo.util.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindLargestValueEachTreeRow {

	public static void main(String args[]) {
		
	}
	
	public static List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        Map<Integer, Integer> levalMax = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<LevelTreeNode> queue = new LinkedList<>();
        queue.add(new LevelTreeNode(root,0));
        while (!queue.isEmpty()) {
        	LevelTreeNode node = queue.poll();
        	Integer max = levalMax.get(node.level);
        	if (max == null) {
        		levalMax.put(node.level, node.node.val);
        	} else if (node.node.val > max) {
        		max = node.node.val;
        		levalMax.put(node.level, node.node.val);
        	}
        	// add left and right to the node
        	queue.add(new LevelTreeNode(node.node.left, node.level + 1));
        	queue.add(new LevelTreeNode(node.node.right, node.level + 1));
        }
    
        for (int i = 0; i < levalMax.size(); i++) {
        	result.add(levalMax.get(0));
        }
        return result;
    }
	
	
	
	
	
}

class LevelTreeNode {
	public TreeNode node;
	public Integer level;
	
	public LevelTreeNode(TreeNode root, Integer level) {
		this.node = root;
		this.level = level;
	}
}
