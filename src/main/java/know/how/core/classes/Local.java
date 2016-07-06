package know.how.core.classes;

public class Local {
	private String name = "Piotr";
	private Double salary = 10.000;
	private static String country = "Poland";
	
	String getName() {
		return name;
	}
	
	Double getSalary() {
		return salary;
	}
	
	String testNestedClass() {
		Pesel pesel = new Pesel();
		pesel.testing = "yyy";
		return pesel.createPesel();
	}
	
	private class Pesel {
		private String testing = "xxx";
		
		private String createPesel() {
			name = "Janek";
			return name + " " + testing;
		}
	}
	
	static class Address {
		String getLocalField() {
			return country;
		}
	}
	
	String testLocalClass(final int i, final String str) {
		final double d = 0.0;
		class NestedLocal {
			private int j = 0;
			
			private String localMethod() {	
				System.out.println(i + " " + str + " " + d);
				System.out.println(name);
				return "done";
			}
		}
		NestedLocal nl = new NestedLocal();
		return nl.localMethod();
	}
	
	public static void main(String[] args) {
		Local l = new Local();
		l.testLocalClass(10, "test");
		System.out.println(l.testNestedClass());
		
		Local.Address address = new Local.Address();
		System.out.println(address.getLocalField());
	}
}
