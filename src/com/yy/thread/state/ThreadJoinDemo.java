package com.yy.thread.state;

import java.util.concurrent.TimeUnit;

public class c {

	public static void main(String[] args) {
		final Thread t = new Thread(){
			
			@Override
			public void run() {
				System.out.println(getName() + "start.");
				try {
					TimeUnit.SECONDS.sleep(3);
					throw new InterruptedException();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName() + "end.");
			}
			
		};
		t.start();
		Thread t2 = new Thread(){

			@Override
			public void run() {
				System.out.println(getName() + "start.");
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName() + "end.");
			}
			
		};
		
		new Thread() {
			public void run() { 
				try {
					System.out.println("start kill...");
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("kill end ...");
			}	
		}.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("EEEE");
			e.printStackTrace();
		}
		System.out.println("...");
		t2.start();
		
	}
	
	
}
