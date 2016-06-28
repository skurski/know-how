package know.how.testing.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor implements Runnable {
	private int id;
	
	Executor(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting id : " + id);
		
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed id " + id);
	}
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i=0; i<5; i++) {
			executor.submit(new Executor(i));
		}
		executor.shutdown();
		System.out.println("Task submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Task completed.");
	}

}