package com.yahoo.mediam;

public class RemoveNthNodeFromEndofList {
	public static void main(String args[]) {
		System.out.println(4^6);
		System.out.println((4)&~6);
		//System.out.println(4&6 << 1);
		//String str = "cc";
		//firstUniqChar(str);
		int data [] = {0,0,1};
		moveZeroes(data);
	}
	
	public static void moveZeroes(int[] nums) {
        int n = nums.length;
        //[0,0,1] n =3
        //[0,1,0] n=3
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                //swap and decrease n by 1
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[n-1] = 0;
                n -= 1;
                i--;
            }
        }
    }
	
	public static int firstUniqChar(String s) {
		
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            } 
        }
        return -1;
    }
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        slow.next = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}
