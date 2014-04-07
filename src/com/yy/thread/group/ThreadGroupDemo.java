package com.yy.thread.group;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		int i = 1;
		while(i > 2) {
			System.out.println("111");
		}
		System.out.println("222");
		
	}
	public static void main1(String[] args) {
		for(;;) {
			System.out.println(new Random().nextInt(1));
		}
	}
	public static void main2(String[] args) throws InterruptedException {
		String threadGroupName = "myGroup";
		ThreadGroup threadGroup = new ThreadGroup(threadGroupName);
		System.out.println(threadGroup);
		System.out.println(Thread.currentThread().getThreadGroup());
		int loopCount = 3;
		Thread interruptRandomThread = null;
		for (int i = 0; i < loopCount; i++) {
			Thread t = new Thread(threadGroup, "a-" + i) {
				@Override
				public void run() {
					while(!Thread.currentThread().isInterrupted()) {
						try {
							TimeUnit.SECONDS.sleep(1);
							System.err.println(this + " group:" + this.getThreadGroup());
						} catch (InterruptedException e) {
							System.out.println("IS:" + Thread.currentThread().isInterrupted());
							System.out.println("IS:" + Thread.currentThread().isInterrupted());
							Thread.currentThread().interrupt();
							System.out.println("IS:" + Thread.currentThread().isInterrupted());
							//e.printStackTrace();
						}
					}
				}
				
			};
			t.setPriority(new Random().nextInt(10) + 1);
			t.start();
			if(i == 1)
				interruptRandomThread = t;
		}
		threadGroup.list();
		
		TimeUnit.SECONDS.sleep(4);
		
		threadGroup.interrupt();
		//interruptRandomThread.interrupt();
		System.out.println("interrupt:" + interruptRandomThread);
		Thread.currentThread().interrupt();
		System.out.println("interrupt111:" + interruptRandomThread);
		TimeUnit.SECONDS.sleep(1);
		
	}

}
