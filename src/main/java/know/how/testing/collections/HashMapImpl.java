package know.how.testing.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl {
	private Map<Person, String> persons = new HashMap<Person, String>();
	
	public void addPerson(Person per) {
		persons.put(per, per.getName());
	}
	
	public String getPerson(Person per) {
		return persons.get(per);
	}
	
	public static void main(String[] args) {
		HashMapImpl test = new HashMapImpl();
		
		test.addPerson(new Person("82041002230", "Piotr Skurski"));
		test.addPerson(new Person("82041002240", "Jarek Danieliszyn"));
		test.addPerson(new Person("82041002250", "Aga Chylińska"));
		
		System.out.println(test.getPerson(new Person("82041002230", "Piotr Skurski")));
		System.out.println(test.getPerson(new Person("82041002240", "Jarek Danieliszyn")));
		System.out.println(test.getPerson(new Person("82041002250", "Aga Chylińska")));
	}
	
}
