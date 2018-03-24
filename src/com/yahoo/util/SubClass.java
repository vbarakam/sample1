package com.yahoo.util;

public class SubClass extends SuperClass {
	private static String TEST = "Sublcass";

	public static void main(String args[]) {
		try {
			System.out.println(TEST);
			System.exit(0);
		} catch (Exception e) {

		} finally {
			System.out.println("finally");
		}
	}
}
