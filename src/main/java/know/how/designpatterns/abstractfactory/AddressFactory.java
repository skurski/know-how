package know.how.designpatterns.abstractfactory;

public class AddressFactory extends AbstractFactory {
	
	@Override
	public AbstractAddress newAddress(String addressType) {
		if(addressType == null) {
			return null;
		}
		
		if(addressType.equalsIgnoreCase("HOME")){ 
			return new HomeAddress("My home street"); 
		} 
		else if(addressType.equalsIgnoreCase("OFFICE")){ 
			return new OfficeAddress("Calea Floreasca 167", "Luxoft"); 
		} 
		
		return null;
	}

}
