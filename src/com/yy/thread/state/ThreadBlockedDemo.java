package com.yy.thread.state;

import java.util.concurrent.TimeUnit;


public class ThreadBlockedDemo {

	public static void main(String[] args) {
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		final Thread t1 = new Thread() {
			public void run() {
				synchronized (lock1) {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println(getName() + " running..");
					}
				}
			}
		};
		final Thread t2 = new Thread() {
			public void run() {
				synchronized (lock2) {
					synchronized (lock1) {
						System.out.println(getName() + " running..");
					}
				}
			}
		};
		t1.start();
		t2.start();
		
		new Thread() {
			public void run() {
				while(true) {
					System.out.println("t1:" + t1.getState());
					System.out.println("t2:" + t2.getState());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
}
