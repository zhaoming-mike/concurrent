package com.yy.thread.communication;

import java.util.concurrent.Exchanger;

@SuppressWarnings("unchecked")
public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();

		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "AAA");
		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "BBB");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}
	
	
}

@SuppressWarnings("unchecked")
class ExchangerRunnable implements Runnable {
	Exchanger exchanger = null;
	Object object = null;
	public ExchangerRunnable(Exchanger exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}
	@Override
	public void run() {
		try {
			Object previous = object; //之前的
			//互换数据
			object = exchanger.exchange(object);
			System.out.println(
					Thread.currentThread().getName() + 
					" exchanged " + previous + 
					" for " + object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
