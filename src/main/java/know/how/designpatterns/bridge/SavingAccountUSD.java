package know.how.designpatterns.bridge;

public class SavingAccountUSD implements ForeignAccount {
	private double balance;
	private static final double EURO_USD_EXCHANGE_RATE = 1.11;
	
	public SavingAccountUSD(double eurBalance){
		this.balance = EURO_USD_EXCHANGE_RATE * eurBalance;
	}

	@Override
	public void verifyAccount() {
		System.out.format("Verify saving account USD, balance = %.2f%n", balance);
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getCurrencyName() {
		return "USD";
	}

}
