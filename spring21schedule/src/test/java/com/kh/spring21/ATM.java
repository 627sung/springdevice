package com.kh.spring21;

public class ATM {
 private long money = 1000000000L;
 
 public synchronized void withdraw() {
	 System.out.println("인출시작했다 ");
	 try {
		Thread.sleep(5000L);
	} catch (Exception e) {}
	 
	 System.out.println("인출끝났다. ");

 }
 
}
