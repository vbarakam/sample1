package com.yahoo.util;

public class OddEvenLinkedList {
	public static void main(String args []) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		ListNode node6 = new ListNode(6);
		node5.next = node6;
		ListNode node7 = new ListNode(7);
		node6.next = node7;
		oddEvenList(node1);
		
		ListNode node = node1;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
	}
	
	
	public static ListNode oddEvenList(ListNode current) {
        if (current == null) {
            return null;
        }
        
        ListNode root = current;
        ListNode evenNode = current.next;
        ListNode evenNodeNext = current.next != null ? current.next.next : null;
        while (evenNode != null) {
            ListNode temp = current.next;
            current.next = evenNodeNext;
            evenNode.next = evenNodeNext != null ? evenNodeNext.next : null;
            evenNode = evenNodeNext != null ? evenNodeNext.next : null;

            evenNodeNext.next = temp;
            
            current = current.next;
            evenNodeNext = evenNode != null ? evenNode.next : null;
        }
        return root;
    }
	
	public static ListNode oddEvenList2(ListNode current) {
        if (current == null) {
            return null;
        }
        
        int i = 3;
        int c = 1;
        ListNode root = current;
        while (current != null) {
            ListNode temp = current;
            ListNode previous = null;
            int t = c;
            while (temp != null && t < i) {
                previous = temp;
                temp = temp.next;
                t++;
            }
            
            if (temp == null) {
                break;
            }
            
            // insert current and temp
            previous.next = temp.next;
            temp.next = current.next;
            current.next = temp;
            current = temp;
            i = i + 2;
            c = c + 1;
        }
        return root;
    }
}
