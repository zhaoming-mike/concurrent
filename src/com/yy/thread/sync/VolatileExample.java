package com.yy.thread.sync;


/**
 * volatile demo
 * @author zhaoming@yy.com
 * 2014-4-8
 */
public class VolatileExample extends Thread {
	
	//共享变量
	private static /*volatile*/ boolean flag = false;
	
	//无限循环读共享变量
	public void run() {
		while (!flag) {
			System.out.println(this + ":" + System.currentTimeMillis());
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 300; i++) {
			new VolatileExample().start();
		}
		Thread.sleep(100);
		flag = true;
	}
	
	
}
