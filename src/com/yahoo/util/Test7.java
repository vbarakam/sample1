package com.yahoo.util;

public class Test7 {
	public static void main(String args[]) {
		//String s = "abbacabba";
		//String s = "abba";
		//String s = "xygfdasabbacabba";
		String s = "cdbabcbabdab";
		//String s = "abb";
		
		 // add $ to the string to handle even palundromes
        char ns [] = new char[2 * s.length() + 1];
        for (int i = 0; i < ns.length; i++) {
            if (i % 2 == 0) {
                ns[i] = '$';
            } else {
                ns[i] = s.charAt(i/2);
            }
        }
        System.out.println(s);
        System.out.println(new String(ns));
        String nss = new String(ns);
        
     // check for polindromes
        int n [] = new int[ns.length]; 
        int max = 0;
        int index = 0;
        for (int i = 0; i < ns.length; i++) {
            n[i] = palindrome(nss, i);
            if (n[i] > max) {
        		max = n[i];
        		index = i;
        	}
        }
        
        System.out.println("max : " + max);
        System.out.println("index : " + index);
        
        for (int n1 :  n) {
        	System.out.print( "$" + n1);
        }
        
        int start = (index - max/2);
        int end =  (index + max/2) + 1;
                
        System.out.println("start : " + start);
        System.out.println("end : " + end);
        
        nss = nss.substring(start, end);
        System.out.println("substring " + nss.replaceAll("\\$", ""));
        
       
        
	}
	
	 public static int palindrome(String s, int pivot) {
	        if (pivot >= s.length()) {
	            return 0;
	        }
	        
	        int j = pivot + 1;
	        int k = pivot - 1;
	        int count = 1;
	        while (k >=0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
	        	count += 2;
	        	k = k -1;
	        	j = j + 1;
	        }
	        
	        return count;
	    }
}
