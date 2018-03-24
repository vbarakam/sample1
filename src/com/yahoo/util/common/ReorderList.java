package com.yahoo.util.common;

import java.util.Stack;

import com.yahoo.util.ListNode;

public class ReorderList {
	public static void main(String args[]) {
		ListNode last = new ListNode(3);
		ListNode next = new ListNode(2, last);
		ListNode start = new ListNode(1, next);

		System.out.println(start);
		reorderList(start);
		System.out.println(start);
	}
	
	 public static void reorderList(ListNode head) {
	        if (head == null) {
	            return;
	        }
	        
	        Stack<ListNode> stack = new Stack<>();
	        int c = 0;
	        ListNode current2 = head;
	        while (current2 != null) {
	            stack.push(current2);
	            current2 = current2.next;
	             c++;
	        }
	        
	        if (c <= 2) {
	            return;
	        }
	       
	        ListNode current = head;
	        ListNode last = reverse(head);
	        
	        int cc = 0;
	        while (current != null && current.next != null && cc < c/2) {
	            cc++;
	            ListNode nextCurrent = current.next;
	            current.next = last;
	            last = last.next;
	            current.next.next = nextCurrent;
	            current = nextCurrent;
	        }
	        current.next = null;
	    }
	 
	 public static ListNode reverse(ListNode head) {
	        Stack<ListNode> stack = new Stack<>();
	        ListNode head1 = new ListNode(head.val, head.next);
	        while (head1 != null) {
	            stack.push(head1);
	            head = head.next;
	        }
	        
	        // build reverse linked list
	        ListNode start = stack.pop();
	        ListNode last = start;
	        while (!stack.empty()) {
	            ListNode node = stack.pop();
	            last.next = node;
	            last = node;
	        }
	        last.next = null;
	        
	        return start;
	    }
}
