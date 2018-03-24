package com.yahoo.util.strings;

public class RabinKarpSearch {
	static int prime = 101;
	public static void main(String args[]) {
		String text = "aaabc"; //5
		String pattern = "abc";//3
		double pHash = createHash(pattern, pattern.length() -1);
		double sHash = createHash(text, pattern.length() -1);
		for (int i = 1; i <= text.length() - pattern.length() + 1; i++ ) {
			// 0 to 2, 1 to 3, 2 to 4
			
			// compare
			if (sHash == pHash) { 
			}
						
			// calculate the hash for substring
			if (i < text.length() - pattern.length() + 1) {
				sHash = recalculateHash(sHash, text, i, i+pattern.length(), i-1);
			}
		}
	}
	
	public static double recalculateHash(double sHash, String text, int start, int end, int excludeIndex) {
		sHash = sHash - text.charAt(excludeIndex);
		sHash = sHash/prime;
		sHash = sHash + text.charAt(end) * Math.pow(prime, end - start);
		return sHash;
	}
	
	public static int createHash(String pattern, int start, int end) {
		int hash = 0;
		for (int i =0; i <= end; i++) {
			hash += pattern.charAt(i) * Math.pow(prime, i); 
		}
		return hash;
	}
	
	public static int createHash(String pattern, int end) {
		int hash = 0;
		for (int i =0; i <= end; i++) {
			hash += pattern.charAt(i) * Math.pow(prime, i); 
		}
		return hash;
	}
}
