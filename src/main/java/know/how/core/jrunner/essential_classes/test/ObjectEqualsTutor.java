package know.how.core.jrunner.essential_classes.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


/**
 * Implement the class Employee methods hashCode () and equals () so
 * Compared to the full name, but not the age of the employee.
 *
 */
public class ObjectEqualsTutor {
	enum EmployeeType {
		ByName, ByFullName, ByAge, Default
	}
	class Employee {
		public String name;
		public String surname;
		public int age;
		
		public Employee(String name, String surname, int age) {
			this.name = name;
			this.surname = surname;
			this.age = age;
		}
		public String getFullName() {
			return this.name+" "+this.surname;
		}
		
		public String toString() {
			return this.name+" "+this.surname+", age:"+age;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((surname == null) ? 0 : surname.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (surname == null) {
				if (other.surname != null)
					return false;
			} else if (!surname.equals(other.surname))
				return false;
			return true;
		}
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("John", "Smith", 35));
		employees.add(new Employee("John", "Smith", 30));
		employees.add(new Employee("John", "Jones", 25));
		employees.add(new Employee("John", "James", 25));
		return employees;
	}
	
	public Set<Employee> getEmployeesSet(EmployeeType type) {
		Set<Employee> employeesSet = new HashSet<Employee>();
		employeesSet.addAll(getEmployees());
		return employeesSet;
	}

	@Test
	public void testEmployees() {	
		List<Employee> employees = getEmployees();
		int index=0;
		for (Employee employee: employees) {
			log("emp"+ index++ +"="+employee);
		}
		
		log("***“Test equals: ***");
		employees = getEmployees(); 
		for (int i=0;i<3;i++) {
			log("emp"+i+".equals(emp"+(i+1)+")="+
					employees.get(i).equals(employees.get(i+1)));
		}
		assertEquals(employees.get(0), employees.get(1));
		assertNotSame(employees.get(1), employees.get(2));
		assertNotSame(employees.get(2), employees.get(3));
	}
	
	@Test
	public void testEmployeesSet() {
		Set<Employee> employeesSet;
		log("***Test HashSetImpl: Employee");
		employeesSet = getEmployeesSet(EmployeeType.ByName);
		for (Employee employee: employeesSet) {
			log(employee);
		}
		assertEquals(employeesSet.size(), 3);
	}
	
	private void log(Object str) {
		System.out.println(str);
	}
}
