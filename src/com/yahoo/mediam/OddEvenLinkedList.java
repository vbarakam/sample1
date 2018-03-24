package com.yahoo.mediam;

public class OddEvenLinkedList {
	public static void main(String args[]) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		oddEvenList(node);
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		// 1->2->3
		ListNode node = head.next, even = head, odd = head.next, odd2 = head.next;
		head = even;
		int index = 2;
		while (node != null) {
			node = node.next;
			if (node != null) {
				if (index % 2 == 0) {
					even.next = node;
					even = even.next;
				} else {
					odd.next = node;
					odd = odd.next;
				}
			}
			index++;
		}

		if (odd2 != null) {
			even.next = odd2;
		}

		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
