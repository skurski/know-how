package know.how.core.threads;


public class Test {
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("Balance start: " + bank.getAccountBalance(0));
		
		Thread worker1 = new Thread(new Worker(bank));
		Thread worker2 = new Thread(new Worker(bank));
		
		worker1.start();
		worker2.start();

		try {
			Thread.sleep(6000);
		} catch(InterruptedException e) {
			//
		}
		
		System.out.println("Balance end: " + bank.getAccountBalance(0));
		
	}
}


