package know.how.designpatterns.observer;

public class ObserverPatternDemo {
	
	public static void main(String[] args) { 
		Bank bank = new Bank();
    	Client john = new Client("John", Gender.MALE);
    	bank.addClient(john);
	}

}
