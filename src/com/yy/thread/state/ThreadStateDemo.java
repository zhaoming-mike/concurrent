package com.yy.thread.state;

import java.util.concurrent.TimeUnit;

public class ThreadStateDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	final Object lock = new Object();
		Thread thread = new Thread() {

			@Override
			public void run() {
				System.out.println("" + this.getName());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("wait finished.");
				}
			}
			
		};
		
		System.out.println("thread:" + thread.getName() + " state:" + thread.getState());
		thread.start();
		System.out.println("thread:" + thread.getName() + " state:" + thread.getState());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread:" + thread.getName() + " state:" + thread.getState());
		synchronized (lock) {
			lock.notify();
		}
		System.out.println("thread:" + thread.getName() + " state:" + thread.getState());
		try {
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		thread.stop();
		try {
			TimeUnit.SECONDS.sleep(2
					);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread:" + thread.getName() + " state:" + thread.getState());
	}
	
	
}
