package Threads_S03;

public class App {

	private int count = 0;
	

	public static void main(String[] args) {
		App app =  new App();
		app.doWork();

	}//main

	public synchronized void increment() {
		count++;
	}
	
	public void doWork() {

		Thread t1 =  new Thread(new Runnable() {
			public void run () {
				for( int i=0 ; i<10000 ; i++) 
					increment();
			} // run
		}); //end the Runnable

		Thread t2 =  new Thread(new Runnable() {
			public void run () {
				for( int i=0 ; i<10000 ; i++) 
					increment();
			} // run
		}); //end the Runnable
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Count is : " + count);
		
	}// doWork


}//class app
