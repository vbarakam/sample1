package com.yahoo.util;

import java.io.IOException;
import java.util.HashSet;

public class Test20 {
	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		}catch(IOException | Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void method(Object o) {
		System.out.println("Object impl");
	}

	public static void method(String s) {
		System.out.println("String impl");
	}
}
