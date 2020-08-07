package com.kh.spring21;

public class Test4 {
	public static void main(String[] args) throws InterruptedException {
//		ATM을 하나 만들고 사람(Thread) 3명에게 이용하도록 지시
		ATM atm = new ATM();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				atm.withdraw();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				atm.withdraw();
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				atm.withdraw();
			}
		};
		t1.start();
		t2.start();
		t3.start();

	}
}