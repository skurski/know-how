package know.how.core.threads;

class Account {
	private volatile Double balance;
	
	Account() {
		this.balance = 0.0;
	}
	
	synchronized void updateBalance(Double d) {
		balance += d;
	}
	
	synchronized Double getBalance() {
		return balance;
	}
}
