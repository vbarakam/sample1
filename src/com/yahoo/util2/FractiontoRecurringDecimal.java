package com.yahoo.util2;

public class FractiontoRecurringDecimal {
	public static void main(String args[]) {
		System.out.println(fractionToDecimal(1, 99));
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (numerator > 0)) ? "-": "");
        int nab = Math.abs(numerator);
        int bab = Math.abs(denominator);
        
        sb.append(nab/bab);
        int num = nab%bab;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        while (num != 0) {
            num *= 10;
            sb.append(num/bab);
            if (sb.charAt(sb.length()-2) == sb.charAt(sb.length()-1)) {
                sb.	replace(sb.length()-2, sb.length(), "(" + sb.charAt(sb.length()-1) + ")");
                break;
            }
            num = num%bab;
        }
        return sb.toString();
    }
}
