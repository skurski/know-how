package know.how.designpatterns.facade;

public class SavingAccount extends AbstractAccount {
	public SavingAccount(double balance) {
        super(balance);
    }
	
	public double maximumAmountToWithdraw(){
        return balance;
    }
	
	@Override
    public void verifyAccount(){
		System.out.format("Saving account, balance = %.2f%n", balance);
    }
	
}