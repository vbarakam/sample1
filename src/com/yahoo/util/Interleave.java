package com.yahoo.util;

public class Interleave {
	public static void main(String argsp[]) {
		String s1 = "aab";
		String s2 = "axy";
		String s3 = "aaxaby";
		String s33 = "abaaxy";
		System.out.println(isInterleave("aabc", "abad", "aabadabc"));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != (s1.length() + s2.length())) {
			return false;
		}
		
		boolean d[][] = new boolean[s2.length() + 1][s1.length() + 1];
		d[0][0] = true;
		
		// update 0th row
		for (int i = 0; i <s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i)) {
				d[0][i+1] = d[0][i];
			} else {
				d[0][i+1] = false;
			}
		}
		
		// update 0th column
		for (int i = 0; i <s2.length(); i++) {
			if (s2.charAt(i) == s3.charAt(i)) {
				d[i+1][0] = d[i][0];
			} else {
				d[i+1][0] = false;
			}
		}
		
		for (int i = 1; i <s2.length() + 1; i++) {
			for (int j = 1; j <s1.length() + 1; j++) {
				boolean s1status = s3.charAt(i+j-1) == s1.charAt(j-1) ? d[i][j-1] : false;
				boolean s2status = s3.charAt(i+j-1) == s2.charAt(i-1) ? d[i-1][j]  : false;
				d[i][j] =  s1status || s2status ;
			}
		}
		
		return d[s2.length()][s1.length()];
	}

	public static boolean isInterleave2(String s1, String s2, String s3) {
		int sp1 = 0;
		int sp2 = 0;

		if (s3.length() != (s1.length() + s2.length())) {
			return false;
		}

		for (int i = 0; i < s3.length(); i++) {
			System.out.println("S1 : " + s1.charAt(sp1));
			System.out.println("S2 : " + s2.charAt(sp2));
			System.out.println("S3 : " + s3.charAt(i));
			if (sp1 < s1.length() && s3.charAt(i) == s1.charAt(sp1) && sp2 < s2.length()
					&& s3.charAt(i) == s2.charAt(sp2)) {
				// both have the char, which one will you use

				// check if current and next chars are different in s1
				if ((sp1 + 1) < s1.length() && (i + 1) < s3.length() && s1.charAt(sp1 + 1) == s3.charAt(i + 1)) {
					sp1 += 1;
				} else if ((sp2 + 1) < s2.length() && (i + 1) < s3.length() && s2.charAt(sp2 + 1) == s3.charAt(i + 1)) {
					sp2 += 1;
				} else
					sp1 += 1;

			} else if (sp1 < s1.length() && s3.charAt(i) == s1.charAt(sp1)) {
				sp1 += 1;
			} else if (sp2 < s2.length() && s3.charAt(i) == s2.charAt(sp2)) {
				sp2 += 1;
			} else {
				return false;
			}
		}
		return true;
	}
}
