package com.yy.thread.communication;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时触发器Demo
 * @author zhaoming@yy.com
 *
 */
public class CountDownLatchDemo {

	static final int countDownSize = 5;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(countDownSize);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		new Thread(waiter).start();
		new Thread(decrementer).start();
		Thread.sleep(6000);
	}
}

/**
 * 等待
 * @author zhaoming@yy.com
 * 2014-4-6
 */
class Waiter implements Runnable {
	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Waiter Released");
	}
}

/**
 * 递减操作
 * @author zhaoming@yy.com
 * 2014-4-6
 */
class Decrementer implements Runnable {
	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			for (int i = 1; i <= CountDownLatchDemo.countDownSize; i++) {
				Thread.sleep(1000);
				this.latch.countDown();
				System.out.println(this + " run " + i + " times.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
