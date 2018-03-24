package com.yahoo.util;

import java.util.Arrays;

public class Test10 {
	public static void main(String args[]) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		
		ListNode slow = root;
		ListNode fast = root;
		ListNode prev;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			prev = fast;
			fast = fast.next.next;
		}
		System.out.println(" slow " + slow);
		System.out.println(" fast " + fast);
	}
}

