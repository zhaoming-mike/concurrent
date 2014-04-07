package com.yy.thread.communication;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		int size = 3;
		Semaphore semaphore = new Semaphore(size);
		for (int i = 1; i <= size; i++) {
			semaphore.acquire();
			System.out.println("Semaphore ACQURIE " + i);
		}
		new MyThread(semaphore).start();
		TimeUnit.SECONDS.sleep(4);
		semaphore.release();
		System.out.println(System.currentTimeMillis() + "" + Thread.currentThread() + " release.");
		TimeUnit.SECONDS.sleep(4);
		
	}
}
class MyThread extends Thread {
	Semaphore semaphore;
	public MyThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(System.currentTimeMillis() + "" + this + " acquire...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
