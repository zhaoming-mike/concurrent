package com.yy.thread.communication;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 1 executed ");
		    }
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed ");
			}
		};
		Runnable barrier3Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 3 executed ");
		    }
		};

		CyclicBarrier barrier1 = new CyclicBarrier(3, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(3, barrier2Action);
		CyclicBarrier barrier3 = new CyclicBarrier(3, barrier3Action);

		CyclicBarrierRunnable barrierRunnable1 =
		        new CyclicBarrierRunnable(barrier1, barrier2, barrier3);

		CyclicBarrierRunnable barrierRunnable2 =
			new CyclicBarrierRunnable(barrier1, barrier2, barrier3);
		
		CyclicBarrierRunnable barrierRunnable3 =
		        new CyclicBarrierRunnable(barrier1, barrier2, barrier3);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
		new Thread(barrierRunnable3).start();
	}
}

/**
 * 循环屏障
 * @author zhaoming@yy.com
 * 2014-4-6
 */
class CyclicBarrierRunnable implements Runnable{

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;
    CyclicBarrier barrier3 = null;

    public CyclicBarrierRunnable(
    		CyclicBarrier barrier1,
            CyclicBarrier barrier2,
            CyclicBarrier barrier3) {

        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
        this.barrier3 = barrier3;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            /*
             * 阻塞等待条件1达成
             */
            this.barrier1.await();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
            /*
             * 阻塞等待条件2达成
             */
            this.barrier2.await();
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 3");
            
            this.barrier3.await();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
