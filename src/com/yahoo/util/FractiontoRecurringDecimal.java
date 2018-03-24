package com.yahoo.util;

import java.util.*;

public class FractiontoRecurringDecimal {
	public static void main(String args[]) {
		int n = 1;
		int d = 99;
		System.out.println(fractionToDecimal(n,d));
	}
	
	public static String fractionToDecimal2(int numerator, int denominator) {
        //if (numerator < denominator) {
        //    return "0";
        //}
        StringBuilder sb = new StringBuilder();
        sb.append(numerator/denominator);
        if (numerator%denominator > 0) {
            sb.append(".");
        }
        int num = numerator%denominator * 10;
        while (num != 0) {
            int d = num/denominator;
            if (sb.charAt(sb.length()-1) == (d + '0')) {
                sb.insert(sb.length()-1, '(');
                sb.append(')');
                break;
            } else {
                sb.append(d);
                num = num%denominator * 10;
            }
        }
        return sb.toString();
    }
	
	public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0) {
            return "0";
        }
        
        StringBuilder builder = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            builder.append("-");
        }
        
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        builder.append(numerator/denominator);
        
        int num = numerator%denominator;
        if (num == 0) {
            return builder.toString();
        }
        builder.append(".");
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(num, builder.length());
        while (num != 0) {
            num *= 10;
            builder.append(num/denominator);
            num = num%denominator;
            if (map.containsKey(num)) {
                int index = map.get(num);
                builder.insert(index,"(");
                builder.append(")");
                break;
            } else {
                map.put(num, builder.length());
                continue;
            }
        }
        
        return builder.toString();
    }
}
