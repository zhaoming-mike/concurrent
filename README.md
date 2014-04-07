Java Concurrent Programming
==========

并发编程

# Java 4.0
* 1.原子操作		synchronized

* 2.锁			synchronized

* 3.线程协作		wait | notity | suspend | resume | yield | join | stop | destroy


# Java 5.0

* 1.原子操作		java.util.concurrent.atomic

* 2.锁			java.util.concurrent.locks

* 3.线程协作		java.util.concurrent

并发编程分享提纲
================

* 1.线程
	* 1.1 State
	
			* new
			
			* runnable
			
			* wait
			
			* time_wait
			
			* blocked
			
			* terminated
			
	* 1.2	Interrupt 中断
	
	* 1.3	Thread Communication:
	
			* Semaphore		信号量
			
			* CountDownLatch	倒数同步
			
			* Exchanger		线程数据交换
			
			* CyclicBarrier 	多路线程同步等待
			
* 2.同步源语

	* 2.1	volatile vs synchronized
	
* 3.锁

	* Reentrantlock
	
	* ReentrantReadWriteLock
	
* 4.并发容器

	* 4.1 concurrent collection:
	
		* ConcurrentLinedQuere
		
		* ConcurrentHashMap
		
		* *ConcurrentSkipListMap
		
		* *ConcurrentSkipListSet
		
		* *ConcurrentTransferQueue
		
	* 4.2	BlockingQueue
	
			* Array
			
			* Linked Queue|Deque
			
			* Transfer 试探
			
			* Delay	延迟
			
			* Synchronous 无元素
			
			* Priority 优先
			
	* 4.3
	
		* CopyOnWriteXXX
		
* 5.线程池

	* ThreadPoolExecutor
	
	* ScheduledThreadPoolExecutor
	
* 6.模式

	* 窃取工作模式
	
	* 缓存一致性协议
	
* 7.其它知识
