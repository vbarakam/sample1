package com.yahoo.util;

public class AddBinary {
	public static void main(String args[]) {
		String a = "11";
		String	b = "1";
		System.out.println(addBinary(a,b));
	}
	public static String addBinary(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int maxString = Math.max(al, bl) + 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int carry = 0; 
        while (index < maxString) {
            index++;
            
            int ac = 0;
            if (al >= 0) {
                ac = a.charAt(al) - '0';
                al--;
            }
            
            int bc = 0;
            if (bl >= 0) {
                bc = b.charAt(bl) - '0';
                bl--;
            }
            
            int cc = ac + bc + carry;
            sb.append(cc%2);
            carry = cc/2;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        StringBuilder sb2 = sb.reverse();
        return sb2.toString();
    }
}
