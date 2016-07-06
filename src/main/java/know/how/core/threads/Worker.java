package know.how.core.threads;

import java.util.Random;

class Worker implements Runnable {
	private Bank b = null;
	
	Worker(Bank b) {
		this.b = b;
	}
	
	public void run() {
		//update account 1
		for(int i=0; i<100; i++) {
			b.updateAccount(0, 10.0);
			try {
				Thread.sleep(new Random().nextInt(100));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + Thread.currentThread().getId() 
					+ " : " + b.getAccountBalance(0));
		}
	}
}
