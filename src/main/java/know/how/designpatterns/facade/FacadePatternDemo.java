package know.how.designpatterns.facade;

public class FacadePatternDemo {
	
	public static void main(String[] args) throws NotEnoughFundsException {
		
		SavingAccount savingAccount = AccountMaker.createSavingAccount(800.00);
		CheckingAccount checkingAccount = AccountMaker.createCheckingAccount(1000.00, 200.00);
		
		AccountMaker.verifyAccount(savingAccount);
		AccountMaker.verifyAccount(checkingAccount);
		
		AccountMaker.withdraw(savingAccount, 200);
		AccountMaker.deposit(checkingAccount, 200);
		
		AccountMaker.verifyAccount(savingAccount);
		AccountMaker.verifyAccount(checkingAccount);
	}

}
