package know.how.designpatterns.bridge;

public class SavingAccountRUB implements ForeignAccount {
	private double balance;
	private static final double EURO_RUB_EXCHANGE_RATE = 61.15;
	
	public SavingAccountRUB(double eurBalance){
		this.balance = EURO_RUB_EXCHANGE_RATE * eurBalance;
	}

	@Override
	public void verifyAccount() {
		System.out.format("Verify saving account RUB, balance = %.2f%n", balance);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getCurrencyName() {
		return "RUB";
	}

}
