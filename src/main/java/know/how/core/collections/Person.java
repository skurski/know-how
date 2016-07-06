package know.how.core.collections;

class Person {
	private String name;
	private String pesel;
	
	Person(String p, String n) {
		name = n;
		pesel = p;
	}
	
	String getName() {
		return name;
	}
	
	String getPesel() {
		return pesel;
	}
	
	@Override
	public int hashCode() {
		return (pesel == null) ? -1 : pesel.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object instanceof Person) {
			Person anPer = (Person) object;
			if (pesel.equals(anPer.pesel)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Person p = new Person("82453252345", "gdsggfds");
		System.out.println(p.hashCode());
	}
}
