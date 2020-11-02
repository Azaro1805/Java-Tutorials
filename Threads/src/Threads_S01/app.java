package Threads_S01;

class Runner extends Thread {


	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++ ) {
			System.out.println("hello " + i);

			try {
				Thread.sleep(100);
			}catch(InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}

}//Runner

public class app {

	public static void main(String[] args) {
		//Thread a = new Thread();
		Runner runner1 = new Runner();
		runner1.start();
		try {
			runner1.sleep(5444);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runner runner2 = new Runner();
		runner2.start();
	}

}
