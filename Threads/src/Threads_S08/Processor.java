package Threads_S08;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException{
		synchronized (this) { 
			System.out.println("Producer thread is running ... ");
			wait();
			System.out.println("Resumed.");
		}
	}
	
	public void consume() throws InterruptedException{
		
		Scanner scanner =  new Scanner (System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key, Press char");
			scanner.nextLine();
			System.out.println("Return key Pressed");
			notify();
			Thread.sleep(2000);
		}
		
	}
}
