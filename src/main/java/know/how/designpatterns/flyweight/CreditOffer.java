package know.how.designpatterns.flyweight;

public class CreditOffer extends AbstractCreditOffer {
	public CreditOffer(double amount) {
        super(amount);
    }

    @Override
    public void verifyOffer(){
    	System.out.format("%s, amount = %.2f%n", getType(), amount);
    }
}