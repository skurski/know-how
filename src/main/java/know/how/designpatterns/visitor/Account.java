package know.how.designpatterns.visitor;

public interface Account {
	void withdraw(double amount) throws NotEnoughFundsException;
	double getBalance();
	public void accept(ComponentVisitor componentVisitor);
}
