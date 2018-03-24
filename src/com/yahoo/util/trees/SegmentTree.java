package com.yahoo.util.trees;

import com.yahoo.util.bits.NextPowerOf2;

public class SegmentTree {
	public static void main(String args[]) {
		int input[] = { 1, 3, 5, 7, 9, 11 };
		SegmentTree stree = new SegmentTree();
		Operation sumOp = new SumOperation();
		NextPowerOf2 power = new NextPowerOf2();
		int p = power.nextPower(input.length);
		System.out.println(p);
		int segmentTree[] = new int[p * 2 - 1];
		stree.buildTree(input, segmentTree, 0, input.length - 1, 0, sumOp);
	}

	public void updateValueForSumOperation(int input[], int segmentTree[], int newVal, int index) {
		int diff = newVal - input[index];
		input[index] = newVal;
		updateVal(segmentTree, 0, input.length - 1, diff, index, 0);
	}

	private void updateVal(int segmentTree[], int low, int high, int diff, int index, int pos) {
		if (index < low || index > high) {
			return;
		}
		segmentTree[pos] += diff;
		int mid = (low+high)/2;
		updateVal(segmentTree, low, mid, diff, index, pos*2+1);
		updateVal(segmentTree, low, mid, diff, index, pos*2+2);
	}

	public void buildTree(int[] input, int[] segmentTree, int low, int high, int pos, Operation ops) {
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}

		int mid = (low + high) / 2;
		buildTree(input, segmentTree, low, mid, pos * 2 + 1, ops);
		buildTree(input, segmentTree, mid + 1, high, pos * 2 + 2, ops);
		segmentTree[pos] = ops.perform(segmentTree[pos * 2 + 1], segmentTree[pos * 2 + 2]);
	}

	public int query(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos, Operation ops) {
		if (qlow <= low && qhigh >= high) {
			return segmentTree[pos];
		}
		
		if (qlow > high || qhigh < low) {
			return 0;
		}
		int mid = (low-high)/2;
		return ops.perform(query(segmentTree, low, mid, qlow, qhigh, pos*2+1, ops), query(segmentTree, mid+1, high, qlow, qhigh, pos*2+2, ops));
	}

	public void update(int[] data, int[] tree, int start, int end, int pos) {

	}
}

interface Operation {
	int perform(int a, int b);
}

class MinOperation implements Operation {

	@Override
	public int perform(int a, int b) {
		return Math.min(a, b);
	}
}

class SumOperation implements Operation {

	@Override
	public int perform(int a, int b) {
		return a + b;
	}
}

class MaxOperation implements Operation {

	@Override
	public int perform(int a, int b) {
		return Math.max(a, b);
	}
}