package know.how.designpatterns.abstractfactory;

public class AccountFactory extends AbstractFactory {
	
	@Override
	public AbstractAccount newAccount(String accountType) {
		if(accountType == null) {
			return null;
		}
		
		if(accountType.equalsIgnoreCase("CHECKING")){ 
			return new CheckingAccount(0.0, 0.0); 
		} 
		else if(accountType.equalsIgnoreCase("SAVING")){ 
			return new SavingAccount(0.0); 
		} 
		
		return null;
	}

}
