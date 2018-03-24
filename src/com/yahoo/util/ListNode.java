package com.yahoo.util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public ListNode(int x, ListNode n) {
		val = x;
		this.next = n;
	}
	
	public String toString() {
		return (val + "" + (this.next != null ? "->" + this.next : ""));
	}
			
}
