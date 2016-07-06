package know.how.core.collections;

import java.util.Set;
import java.util.TreeSet;

public class SetComparison {
	
	public void checkSet() {
		Set<Person> persons = new TreeSet<Person>();
		persons.add(new Person("Kowalski", "11111"));
		persons.add(new Person("Heniek", "44444"));
		persons.add(new Person("Zbychu", "55555"));
		persons.add(new Person("Kowalski", "77777"));
		
		for (Person p : persons) System.out.println(p);
		
		Object test = new Object();
	}
	
	public static void main(String[] args) {
		SetComparison set = new SetComparison();
		set.checkSet();
	}
	
	private class Person implements Comparable<Person> {
		private String name;
		private final String pesel;
		
		Person(String n, String p) {
			pesel = p;
			name = n;
		}
		
		public String toString() {
			return name + " " + pesel;
		}
		
		public boolean equals(Object o) {
			if (this == o) 
				return true;
			if (!(o instanceof Person))
				return false;
			Person p2 = (Person) o;
			if (this.pesel == p2.pesel)
				return true;
			return false;
		}
		
		public int compareTo(Person p) {
			int nameComp = this.name.compareTo(p.name);
			return (nameComp != 0) ? nameComp : this.pesel.compareTo(p.pesel);
		}
	}
}

