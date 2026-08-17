

Java Concurrent Programming
==========

Concurrent Programming

# Java 4.0

* 1. Atomic Operations		synchronized

* 2. Locks			synchronized

* 3. Thread Cooperation		

	* wait | notify 
	* suspend | resume 
	* yield | join 
	* stop | destroy


# Java 5.0

* 1. Atomic Operations		java.util.concurrent.atomic

* 2. Locks			java.util.concurrent.locks

* 3. Thread Cooperation		java.util.concurrent

Concurrent Programming Sharing Outline
================

* 1. Thread
	* 1.1 State
	
		* new
		* runnable
		* waiting
		* timed_waiting
		* blocked
		* terminated
			
	* 1.2	Interrupt
	
	* 1.3	Thread Communication:
	
		* Semaphore
		* CountDownLatch
		* Exchanger
		* CyclicBarrier
		* Phaser (fork/join synchronization)
			
* 2. Synchronization Primitives

	* 2.1	
		* volatile
		* synchronized
* 3. Locks

	* ReentrantLock
	
	* ReentrantReadWriteLock
	
* 4. Concurrent Containers

	* 4.1 Concurrent Collections:
	
		* ConcurrentLinkedQueue
		* ConcurrentHashMap
		* ConcurrentSkipListMap
		* ConcurrentSkipListSet
		* ConcurrentTransferQueue
		
	* 4.2	BlockingQueue
		* ArrayBlockingQueue: An array-based **bounded** blocking queue
		* LinkedBlockingQueue: A linked-list-based **bounded** blocking queue
		* LinkedBlockingDeque: A linked-list-based **dual-ended** blocking queue
		* PriorityBlockingQueue: An unbounded blocking queue supporting priority ordering
		* DelayQueue: An unbounded blocking queue implemented using a priority queue
		* SynchronousQueue: A blocking queue that **does not store elements**
		* LinkedTransferQueue: A linked-list-based **unbounded** blocking queue
		
			
	* 4.3
	
		* CopyOnWriteXXX
		
* 5. Thread Pools

	* ThreadPoolExecutor
	* ScheduledThreadPoolExecutor
	
* 6. Patterns

	* Work-Stealing Pattern
	* Cache Coherence Protocol
	
* 7. Other Knowledge
	* Thread Pool Best Practices
		* For CPU-intensive tasks, configure the thread pool with a minimal number of threads, e.g., N*CPU+1.
		* For IO-intensive tasks, since threads are not always executing, configure a larger thread pool, e.g., 2*N*CPU.
		* For mixed tasks, split them into one CPU-intensive task and one IO-intensive task. Provided their execution times are not significantly different, the throughput after decomposition will exceed that of serial execution.
	* Concurrent Programming
		* Thread Communication Issues (controlled by JMM)
		* Thread Synchronization Issues

		* Heap (Shared Variables): Instance variables, static variables, arrays 
		* Stack (Private Variables):
			* Local variables,
			* Exception handler parameters,
			* Formal method parameters

		* Main memory
		* Local memory: An abstract concept representing caches, write buffers, registers, and hardware/compiler optimizations.

		* Reordering: Improves performance. Compilers and processors perform instruction reordering.
			* 1. Compiler optimization
			* 2. Instruction-Level Parallelism (ILP) reordering (Modern processors)
			* 3. Memory system reordering (Processors utilize caches and read/write buffers) 
		
	* happens-before

		* Program order rule. Each action in a thread happens-before every action in that thread that comes later in the program order. 
		(*Program order rule*: Within a single thread, an operation that appears earlier in the program flow happens-before an operation that appears later in time.)

		* Monitor lock rule. An unlock on a monitor lock happens-before every subsequent lock on that same monitor lock.
		(*Monitor lock rule*: An `unlock` operation happens-before any subsequent `lock` operation on the same monitor.)

		* Volatile variable rule. A write to a volatile field happens-before every subsequent read of that same field.
		(*Volatile variable rule*: A write to a volatile variable happens-before any subsequent read of that variable.)

		* Thread start rule. A call to Thread.start on a thread happens-before every action in the started thread.
		(*Thread start rule*: The `start()` method of a Thread object happens-before every action executed within that thread.)

		* Thread termination rule. Any action in a thread happens-before any other thread detects that thread has terminated, either by successfully returning from Thread.join or by Thread.isAlive returning false. 
		(*Thread termination rule*: All operations in a thread happen-before the termination of that thread is detected by another thread, which can be observed via `Thread.join()` completion or `Thread.isAlive()` returning false.)

		* Interruption rule. A thread calling interrupt on another thread happens-before the interrupted thread detects the interrupt (either by having InterruptedException thrown, or invoking isInterrupted or interrupted).
		(*Thread interruption rule*: Calling the `interrupt()` method on a thread happens-before the interrupted thread's code detects the interrupt event.)

		* Finalizer rule. The end of a constructor for an object happens-before the start of the finalizer for that object.
		(*Object finalization rule*: The completion of an object's initialization (end of constructor) happens-before the start of its `finalize()` method.)

		* Transitivity. If A happens-before B, and B happens-before C, then A happens-before C. 
		(*Transitivity*: If operation A happens-before operation B, and operation B happens-before operation C, then A happens-before C.)
