package know.how.core.jrunner.io.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SerializableTutor {

	private static final String FILE_OBJECT_DATA = "object.data";

	/**
    * Make the class static, implement Serializable
    * and mark the field age as transient
    */
	static class Person implements Serializable {
		public String name;
		public Date birthdate;
		public List<Address> addressList = new ArrayList<Address>();
		transient Integer age;
		
		public Person(String name, Date birthdate) {
			super();
			this.name = name;
			this.birthdate = birthdate;
			age = new Date().getYear() - birthdate.getYear();
		}
		
		public void addAddress(Address address) {
			addressList.add(address);
		}
	}
	
	static class Address implements Serializable {
		public String city;
		public String street;
		public Integer appartment;
		public Address(String city, String street, Integer appartment) {
			super();
			this.city = city;
			this.street = street;
			this.appartment = appartment;
		}
	}
	
	/**
	 * Should write the data of AbstractPerson to file FILE_OBJECT_DATA,
	 * using ObjectOutputStream
	 * @param person
	 */
	public void writeToFile(Person person) {
		try (ObjectOutputStream ous = new ObjectOutputStream
				(new FileOutputStream(FILE_OBJECT_DATA))) {
			ous.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads and returns data from file FILE_OBJECT_DATA
	 * @return
	 */
	public Person readFromFile() {
		Person person = null;
		try (ObjectInputStream ois = new ObjectInputStream
				(new FileInputStream(FILE_OBJECT_DATA))) {
			person = (Person) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	@Test
	public void testObjectSerialize() {
		Person person = new Person("John Johnes", new Date("2000/10/10"));
		writeToFile(person);
		log("Age:"+person.age);
		Person personFromFile = readFromFile();
		log("Name from file:"+personFromFile.name);
		log("Age from file:"+personFromFile.age);
		assertEquals(personFromFile.name, person.name);
		assertFalse("Name age was not marked as transient", 
		    person.age.equals(personFromFile.age));
	}
	
	/**
	 * Uncomment @Test and edit class Address,
	 * so that it allows the address serialization
	 */
	@Test
	public void testPersonAddressSerialize() {
		Person person = new Person("John Johnes", new Date("2000/10/10"));
		Address address = new Address("New York", "Water street", 10); 
		person.addAddress(address);

		writeToFile(person);
		
		log("Age:"+person.age);
		Person personFromFile = readFromFile();
		log("Name from file:"+personFromFile.name);
		log("Age from file:"+personFromFile.age);
		assertEquals(personFromFile.name, personFromFile.name);
		assertFalse(person.age.equals(personFromFile.age));

		Address addressFromFile = personFromFile.addressList.get(0);
		log("City from file:"+addressFromFile.city);
		log("Appartment from file:"+addressFromFile.appartment);
		assertEquals(addressFromFile.city, address.city);
		assertEquals(addressFromFile.appartment, address.appartment);
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
	
}

