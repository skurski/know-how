package know.how.designpatterns.abstractfactory;

public class OfficeAddress extends AbstractAddress {
	private String companyName;
	
	public OfficeAddress(String street, String companyName) {
		super(street);
		this.companyName = companyName;
	}

	@Override
	public String fullAddress() {
		return companyName + ", " + getStreet();
	}

}
