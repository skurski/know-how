package know.how.designpatterns.flyweight;

public abstract class AbstractCreditOffer {
    private String type;
	double amount;
	
	abstract void verifyOffer();

    public AbstractCreditOffer(double amount){
        this.amount = amount;
    }
    
    public String getType(){ 
    	return type; 
    }
    
    public void setType(String type) {
		this.type = type;
	}
    
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}