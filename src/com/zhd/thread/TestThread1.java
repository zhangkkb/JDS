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

//�����������̷߳���ͬһ������object�е����synchronized(this)ͬ�������ʱ��һ��ʱ����ֻ����һ���̵߳õ�ִ�С�
//��һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣
class DoThread1 implements Runnable {
	public void run() {
		synchronized(this) {
			System.out.println("=============");
			for(int i = 0; i < 5; i++)
				System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName() + " : " + i);
		}
	}
}

//��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
//��һ���߳���Ȼ���Է��ʸ�object�еķ�synchronized(this)ͬ������顣
//��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
//�����̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������
//Ҳ����˵����һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ�����ͻ�������object�Ķ�������
//����������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������
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

