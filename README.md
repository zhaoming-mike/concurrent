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
		* ArrayBlockingQueue	数组构成的**有界**阻塞队列
		* LinkedBlockingQueue	链表构成的**有界**阻塞队列
		* LinkedBlockingDeque	链表结构的**双端**阻塞队列
		* PriorityBlockingQueue	支持优先级排序的**无界**阻塞队列
		* DelayQueue		使用优先级队列实现的**无界**阻塞队列
		* SynchronousQueue	**不存储元素**的阻塞队列
		* LinkedTransferQueue	链表结构的**无界**阻塞队列
		
			
	* 4.3
	
		* CopyOnWriteXXX
		
* 5.线程池

	* ThreadPoolExecutor
	* ScheduledThreadPoolExecutor
	
* 6.模式

	* 窃取工作模式
	* 缓存一致性协议
	
* 7.其它知识
	* 线程池经验
		* CPU密集型任务配置尽可能小的线程，如配置N*CPU+1个线程的线程池。
		* IO密集型任务则由于线程并不是一直在执行任务，则配置尽可能多的线程，如2*N*CPU。
		* 混合型的任务则将其拆分成一个CPU密集型任务和一个IO密集型任务，前提是这两个任务执行的时间相差不是太大，那么分解后执行的吞吐率要高于串行执行的吞吐率。
	*并发编程
		* 线程通信问题 (JMM控制)
		* 线程同步问题

		* 堆中(共享变量)：实例变量、静态变量、数组 
		* 栈中(私有变量)：
			* 局部变量(Local variables)、
			* 异常处理器参数(exception handler parameters)、
			* 方法定义参数(formal method parameters)

		* main memory
		* local memory	抽象概念:抽象了缓存、写缓冲区、寄存器、以及硬件和编译优化

		* 重排序：提高性能 编译器和处理器会做重排序
			* 1.编译器优化
			* 2.指令级并行重排序(Instruction-Level Parallelism， ILP) 现代处理器
			* 3.内存系统重排序 (处理器使用了缓存和读写缓冲区) 
		
	* happens-before

		* Program order rule. Each action in a thread happens-before every action in that thread that comes later in the program order. 
		(**程序次序规则**：在一个单独的线程中，按照程序代码的执行流顺序，(时间上)先执行的操作happen—before(时间上)后执行的操作。)

		* Monitor lock rule. An unlock on a monitor lock happens-before every subsequent lock on that same monitor lock.
		(**管理锁定规则**：一个unlock操作happen—before后面(时间上的先后顺序，下同)对同一个锁的lock操作。)

		* Volatile variable rule. A write to a volatile field happens-before every subsequent read of that same field.
		(**volatile变量规则**：对一个volatile变量的写操作happen—before后面对该变量的读操作。)

		* Thread start rule. A call to Thread.start on a thread happens-before every action in the started thread.
		(**线程启动规则**：Thread对象的start()方法happen—before此线程的每一个动作。)

		* Thread termination rule. Any action in a thread happens-before any other thread detects that thread has terminated, either by successfully return from Thread.join or by Thread.isAlive returning false. 
		(**线程终止规则**：线程的所有操作都happen—before对此线程的终止检测，可以通过Thread.join()方法结束、Thread.isAlive()的返回值等手段检测到线程已经终止执行。)

		* Interruption rule. A thread calling interrupt on another thread happens-before the interrupted thread detects the interrupt (either by having InterruptedException tHRown, or invoking isInterrupted or interrupted).
		(**线程中断规则**：对线程interrupt()方法的调用happen—before发生于被中断线程的代码检测到中断时事件的发生。)

		* Finalizer rule. The end of a constructor for an object happens-before the start of the finalizer for that object.
		(**对象终结规则**：一个对象的初始化完成(构造函数执行结束)happen—before它的finalize()方法的开始。)

		* Transitivity. If A happens-before B, and B happens-before C, then A happens-before C. 
		(**传递性**：如果操作A happen—before操作B，操作B happen—before操作C，那么可以得出A happen—before操作C。)
