package know.how.designpatterns.bridge;

public class BridgePatternDemo {
	
	public static void main(String[] args) { 
		AbstractAccount eurAccount = new SavingAccount(new SavingAccountUSD(100.00)); 
		eurAccount.verifyAccount(); 
		
		eurAccount.setForeignAccount(new SavingAccountRUB(1000.00));
		eurAccount.verifyAccount();
	}

}
