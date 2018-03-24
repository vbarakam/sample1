package com.yahoo.util3;

public class CopyListwithRandomPointer {

	public static void main(String args[]) {
		int dividend = -1, divisor = -‰=1;
		int sign = 1;
        if ((dividend < 0) ^ (divisor < 0)) {
            sign = 1;
        } else {
            sign = -1;
        }
        System.out.println(sign);
        
		/*RandomListNode root = new RandomListNode(-1);
		root.random = root;
		CopyListwithRandomPointer randomPointer = new CopyListwithRandomPointer();
		randomPointer.copyRandomList(root);*/
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode temp = node.next;
            node.next = cloneNode(node);
            node = temp;
        }
        node = head;
        while (node != null) {
            node = node.next;
            if (node.random != null) {
                node.random = node.random.next;
            }
            node = node.next;
        }
        node = head;
        RandomListNode clone = null;
        RandomListNode chead = null;
        // 1->1'->2->2'
        // 1->2->2' and clone = 1' and node = 2
        // clone = 1'-2' and node = 2
        while (node != null && node.next != null) {
            if (clone == null) {
                clone = node.next;
                chead = clone;
            } else {
                clone.next = node.next;
            }
            node.next = clone.next;
            node = node.next;
        }
        return chead;
    }
    
    private RandomListNode cloneNode(RandomListNode head) {
        RandomListNode clone = new RandomListNode(head.label);
        clone.next = head.next;
        clone.random = head.random;
        return clone;
    }
	
	public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        // clone main Node
        RandomListNode node = head;
        while (node != null) {
            RandomListNode clone = cloneNode(node);
            node.next = clone;
            node = clone.next;
        }
        
        // link random
        node = head.next;
        while (node != null) {
            node.random = node.random != null ? node.random.next : null;
            node = node.next != null ? node.next.next : null;
        }
        
        // remove cloned copies
        node = head;
        RandomListNode nHead = head.next;
        RandomListNode nNode = nHead;
        node.next = head.next != null ? head.next.next : null;
        node =  node.next;
        while (node != null) {
            nNode.next = nNode.next != null ? nNode.next.next : null;
            nNode = nNode.next;

            node.next = node.next != null ? node.next.next : null;
            node = node.next;
        }
        
        return nHead;
    }
    
    private RandomListNode cloneNode2(RandomListNode head) {
        RandomListNode cNode = new RandomListNode(head.label);
        cNode.next = head.next;
        cNode.random = head.random;
        return cNode;
    }
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}