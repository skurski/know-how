package know.how.designpatterns.bridge;

public class SavingAccount extends AbstractAccount {
	
	public SavingAccount(ForeignAccount foreignAccount) {
        super(foreignAccount);
    }
	
	@Override
    public void verifyAccount(){
		System.out.format("Verify EURO saving account, balance has equivalent of %.2f %s%n", foreignAccount.getBalance(), foreignAccount.getCurrencyName());
    }

}