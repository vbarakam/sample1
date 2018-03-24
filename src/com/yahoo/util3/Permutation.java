package com.yahoo.util3;

public class Permutation {
	static int  count = 0;
	public static void permutation(String sofar, String remain) {
		if (remain.length() == 0) {
			System.out.println(count++);
			System.out.println(" final sofar " + sofar);
			return;
		}
		//for (int i = remain.length() -1; i >= 0; i--) {
		for (int i = 0; i < remain.length(); i++) {
			String str = remain.substring(0, i) + remain.substring(i+1);
			//System.out.println("remain == " + str);
			String so = sofar + Character.toString(remain.charAt(i));
			//System.out.println("sofar " + so);
			permutation(so, str);
		}
	}
	
	public static void combinations(String sofar, String remain, int start) {
		if (start == remain.length()) {
			System.out.println(count++);
			System.out.println(" final sofar " + sofar);
			return;
		}
		//for (int i = remain.length() -1; i >= 0; i--) {
		for (int i = start; i < remain.length(); i++) {
			String str = remain.substring(start, i) + remain.substring(i+1);
			//System.out.println("remain == " + str);
			String so = sofar + Character.toString(remain.charAt(i));
			//System.out.println("sofar " + so);
			combinations(so, str, start+1);
		}
	}

	public static void main(String args[]) {
		Permutation perm = new Permutation();
		//perm.permutation("","abcde");
		perm.combinations("","abcde", 0);
	}
}
