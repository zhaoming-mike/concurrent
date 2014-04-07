package com.yy.thread.state;

import java.util.concurrent.TimeUnit;

public class ThreadTimeWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		final Thread t = new Thread() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				synchronized (this) {
					System.out.println(this);
						try {
							this.wait(1000 * 3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(this + " end.");
						try {
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(this + " notifyed.");
				}
			}
		};
		new Thread() {
			public void run() {
				while(true) {
					try {
						TimeUnit.MILLISECONDS.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(t.getState());
				}
			}
		}.start();
		synchronized (t) {
			TimeUnit.SECONDS.sleep(3);
		}
		t.start();
		synchronized (t) {
			TimeUnit.SECONDS.sleep(5);
		}
		TimeUnit.SECONDS.sleep(10);
		synchronized (t) {
			t.notify();
		}
	}
}
