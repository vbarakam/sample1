package com.yahoo.util;

public class TitleToNumber {
	public static void main(String args[]) {
		String data = "A,B";
		String splits[] = data.split("\\,");
		for (String split : splits) {
			System.out.println(split);
		}
	}
	
	public static int titleToNumber(String s) {
        int sum = 0;
        for (int index = s.length() -1; index >= 0; index--) {
            int c = (s.charAt(index) - 'A' + 1);
            sum +=  c * Math.pow(26,s.length() -1 - index);
        }
        return sum;
    }
}
