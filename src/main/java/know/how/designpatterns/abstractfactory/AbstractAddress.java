package know.how.designpatterns.abstractfactory;

public abstract class AbstractAddress {
	private String street;
	
	public AbstractAddress(String street){
        this.street = street;
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public abstract String fullAddress();

}
