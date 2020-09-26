package Threads_S05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

	private int id ;
	
	
	public Processor (int id ) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Thread id : "+ id + ", stating : ");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread id : "+ id + ", Completed ");

	}

}

public class App {


	public static void main (String [] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for (int i=0; i<5 ; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("All the task is submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("All the task is completed");

	}//main
}
