package com.yahoo.util;

public class ReverseLinkedList {

	public static void main(String args[]) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		// check null
		ListNode root = reverse(null);
		System.out.println(root);
		
		// check 1 nodes
		System.out.println("check 1 nodes");
		root = reverse(node1);
		System.out.println(root);
		System.out.println(root.val);
		
		// check 2 nodes
		node1.next = node2;
		root = reverse(node1);
		System.out.println("check 2 nodes");
		System.out.println(root.val);
		System.out.println(root.next.val);
		
		// check 3 nodes
		node1.next = node2;
		node2.next = node3;
		System.out.println("check 3 nodes");
		root = reverse(node1);
		System.out.println(root.val);
		System.out.println(root.next.val);
		System.out.println(root.next.next.val);
	}
	
	 public  static ListNode reverse(ListNode headA) {
	        if (headA == null) {
	            return null;
	        }
	        ListNode previous = null;
	        ListNode node = headA;
	        while (node != null) {
	            ListNode temp = node.next;
	            node.next = previous;
	            previous = node;
	            node = temp;
	        }
	        return previous;
	    }
}
