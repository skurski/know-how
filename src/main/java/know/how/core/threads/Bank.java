package know.how.core.threads;

import java.util.ArrayList;
import java.util.List;

class Bank {
	List<Account> accounts = new ArrayList<Account>();
	
	Bank() {
		for(int i=0; i<10; i++) {
			accounts.add(new Account());
		}
	}
	
	void updateAccount(int id, Double add) {
		accounts.get(id).updateBalance(add);
	}
	
	Double getAccountBalance(int id) {
		return accounts.get(id).getBalance();
	}
}
