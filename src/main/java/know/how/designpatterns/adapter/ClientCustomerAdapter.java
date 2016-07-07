package know.how.designpatterns.adapter;

public class ClientCustomerAdapter implements Client {
	
	private Customer customer;
	
	public ClientCustomerAdapter(Gender gender, String surname, String firstName) {
		customer = new CustomerImpl(gender, surname, firstName);
	}

	@Override
	public String greet() {
		return customer.salut();
	}

}
