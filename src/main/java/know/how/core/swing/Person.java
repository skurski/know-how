package know.how.core.swing;

import java.io.Serializable;

class Person implements Serializable {
	private String name;
	private String surname;
	private String email;
	
	Person(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public String toString() {
		return name + " " + surname + " " + email;
	}
}
