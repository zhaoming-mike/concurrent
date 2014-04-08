Java Concurrent Programming
==========

并发编程

# Java 4.0

* 1.原子操作		synchronized

* 2.锁			synchronized

* 3.线程协作		

	* wait | notity 
	* suspend | resume 
	* yield | join 
	* stop | destroy


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
		* CyclicBarrier		多路线程同步等待
			
* 2.同步源语

	* 2.1	
		* volatile
		* synchronized
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
	* happens-before

		* Program order rule. Each action in a thread happens-before every action in that thread that comes later in the program order. 
		(**程序次序规则**：在一个单独的线程中，按照程序代码的执行流顺序，(时间上)先执行的操作happen—before(时间上)后执行的操作。)

		* Monitor lock rule. An unlock on a monitor lock happens-before every subsequent lock on that same monitor lock.(管理锁定规则：一个unlock操作happen—before后面(时间上的先后顺序，下同)对同一个锁的lock操作。)

		* Volatile variable rule. A write to a volatile field happens-before every subsequent read of that same field.(volatile变量规则：对一个volatile变量的写操作happen—before后面对该变量的读操作。)

		* Thread start rule. A call to Thread.start on a thread happens-before every action in the started thread.(线程启动规则：Thread对象的start()方法happen—before此线程的每一个动作。)

		* Thread termination rule. Any action in a thread happens-before any other thread detects that thread has terminated, either by successfully return from Thread.join or by Thread.isAlive returning false. (线程终止规则：线程的所有操作都happen—before对此线程的终止检测，可以通过Thread.join()方法结束、Thread.isAlive()的返回值等手段检测到线程已经终止执行。)

		* Interruption rule. A thread calling interrupt on another thread happens-before the interrupted thread detects the interrupt (either by having InterruptedException tHRown, or invoking isInterrupted or interrupted).(线程中断规则：对线程interrupt()方法的调用happen—before发生于被中断线程的代码检测到中断时事件的发生。)

		* Finalizer rule. The end of a constructor for an object happens-before the start of the finalizer for that object.(对象终结规则：一个对象的初始化完成(构造函数执行结束)happen—before它的finalize()方法的开始。)

		* Transitivity. If A happens-before B, and B happens-before C, then A happens-before C. (传递性：如果操作A happen—before操作B，操作B happen—before操作C，那么可以得出A happen—before操作C。)
