package com.yahoo.concurrent;

public class Deadlock {
	public static void main(String args[]) {
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		
		Thread th1 = new Thread(new Thread1(s1,s2));
		Thread th2 = new Thread(new Thread1(s2,s1));
		th1.start();
		th2.start();
	}
}

class Util {
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}	
}

class Shared {
	public synchronized void test1(Shared s2) {
		System.out.println(" Entering test 1 ");
		Util.sleep(10);
		s2.test2(this);
		System.out.println(" Exiting test 1 ");
	}
	
	public synchronized void test2(Shared s1) {
		System.out.println(" Entering test 2 ");
		Util.sleep(10);
		s1.test1(this);
		System.out.println(" Exiting test 2 ");
	}
}

class Thread1 implements Runnable {
	private Shared s1;
	private Shared s2;
	
	public Thread1(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public void run() {
		s1.test1(s2);
	}
}

