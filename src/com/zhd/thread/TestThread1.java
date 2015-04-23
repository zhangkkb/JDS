package com.zhd.thread;

public class TestThread1 {
	
	public static void main(String[] args) {
		//tCase1();
		//tCase2();
		tCase3();
	}
	
	private static void tCase1() {
		DoThread1 dt = new DoThread1();
		Thread th1 = new Thread(dt, "thread 1");
		Thread th2 = new Thread(dt, "thread 2");
		th1.start();
		th2.start();
	}
	
	private static void tCase2() {
		final DoThread2 dt = new DoThread2();
		Thread th1 = new Thread(new Runnable() { public void run() {dt.m4t1();}}, "thread 1");	
		Thread th2 = new Thread(new Runnable() { public void run() {dt.m4t2();}}, "thread 2");	
		th1.start();
		th2.start();
	}
	
	private static void tCase3() {
		final DoThread2 dt = new DoThread2();
		Thread th1 = new Thread(new Runnable() { public void run() {dt.m4t1();}}, "thread 1");	
		Thread th2 = new Thread(new Runnable() { public void run() {dt.m4t3();}}, "thread 2");	
		th1.start();
		th2.start();
	}
}

//当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
//另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
class DoThread1 implements Runnable {
	public void run() {
		synchronized(this) {
			System.out.println("=============");
			for(int i = 0; i < 5; i++)
				System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName() + " : " + i);
		}
	}
}

//当一个线程访问object的一个synchronized(this)同步代码块时，
//另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
//当一个线程访问object的一个synchronized(this)同步代码块时，
//其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
//也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。
//结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
class DoThread2 {
	public void m4t1() {
		synchronized(this) {
			int i = 5;
			while(i-->0) {
				System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName() + " : " + i);
				try { Thread.sleep(500);} catch(InterruptedException ie) {}
			}
		}
	}
	
	public void m4t2() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName() + " : " + i);
			try { Thread.sleep(500);} catch (InterruptedException ie) {}
		}
	}
	
	public void m4t3() {
		synchronized(this) {
			int i = 5;
			while(i-->0) {
				System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName() + " : " + i);
				try { Thread.sleep(500);} catch(InterruptedException ie) {}
			}
		}
	}
}

