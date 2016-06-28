package know.how.testing.threads;

public class Synchronize {
	private int count = 0;
	
	public static void main(String[] args) {
		Synchronize synch = new Synchronize();
		synch.doStuff();
	}
	
	private synchronized void increment() {
		count++;
	}
	
	private void doStuff() {
		Thread[] threads = new Thread[3];
		
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					for (int i=0; i<10000; i++) {
						increment();
					}
				}
			});
		}
		
		for (Thread t: threads) t.start();
		
		for (Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The value of count is: " + count);
	}
}
