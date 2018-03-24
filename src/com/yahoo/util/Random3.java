package com.yahoo.util;

import java.util.Random;

public class Random3 {
	public static void main(String args[]) {
		Random ran = new Random();
		for (int i =10; i > 0; i--) {
			System.out.println(ran.nextInt(i));
		}
	}
}
