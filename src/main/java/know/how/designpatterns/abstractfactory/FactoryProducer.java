package know.how.designpatterns.abstractfactory;

public class FactoryProducer {
	public static AbstractFactory newFactory(String choice){ 
		if(choice.equalsIgnoreCase("ACCOUNT")){ 
			return new AccountFactory(); 
		} 
		else if(choice.equalsIgnoreCase("ADDRESS")){ 
			return new AddressFactory(); 
		} 
		return null; 
	}
	
	public static void main(String[] args) { 
		AbstractFactory accountFactory = FactoryProducer.newFactory("ACCOUNT"); 
		
		AbstractAccount account1 = accountFactory.newAccount("CHECKING");
		account1.verifyAccount();
		
		AbstractAccount account2 = accountFactory.newAccount("SAVING");
		account2.verifyAccount();

		
		AbstractFactory addressFactory = FactoryProducer.newFactory("ADDRESS");
		
		AbstractAddress address1 = addressFactory.newAddress("HOME");
		System.out.println(address1.fullAddress());
		
		AbstractAddress address2 = addressFactory.newAddress("OFFICE");
		System.out.println(address2.fullAddress());
		
	}

}
