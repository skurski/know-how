package know.how.designpatterns.abstractfactory;

public class HomeAddress extends AbstractAddress {
	
	public HomeAddress(String street) {
		super(street);
	}

	@Override
	public String fullAddress() {
		return getStreet();
	}

}
