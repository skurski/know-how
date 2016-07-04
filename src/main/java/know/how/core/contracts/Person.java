package know.how.core.contracts;

import java.util.Arrays;

/**
 * Implement 3 important methods according to their contracts.
 * Methods: equals, hashcode, compareTo
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private float salary;
    private double savings;
    private long timestamp;
    private boolean adult;
    private char prefix;
    private int[] expenses;

    public Person(String name, int age, float salary, double savings, long timestamp, boolean adult, char prefix,
                  int[] expenses) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.savings = savings;
        this.timestamp = timestamp;
        this.adult = adult;
        this.prefix = prefix;
        this.expenses = expenses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (! (obj instanceof Person)) return false;

        Person person = (Person) obj;

        if (age != person.age) return false;
        if (salary != person.salary) return false;
        if (savings != person.savings) return false;
        if (timestamp != person.timestamp) return false;
        if (adult != person.adult) return false;
        if (prefix != person.prefix) return false;
        if (name != null) {
            if (!name.equals(person.name)) return false;
        }
        if (expenses != null) {
            if (!Arrays.equals(expenses, person.expenses)) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + Float.floatToIntBits(salary);
        long temp = Double.doubleToLongBits(savings);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (adult ? 1 : 0);
        result = 31 * result + (int) prefix;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (expenses != null ? Arrays.hashCode(expenses) : 0);
        return result;
    }

    @Override
    public int compareTo(Person person) {
        if (this == person) return 0;

        if (name != null) {
            int nameDiff = name.compareTo(person.name);
            if (nameDiff != 0) return nameDiff;
        }

        int ageDiff = age - person.age;
        if (age != 0) return ageDiff;

        int salaryDiff = Float.compare(salary, person.salary);
        if (salaryDiff != 0) return salaryDiff;

        int savingsDiff = Double.compare(savings, person.savings);
        if (salaryDiff != 0) return savingsDiff;

        if (timestamp < person.timestamp) return -1;
        if (timestamp > person.timestamp) return 1;

        if (adult && !adult) return -1;
        if (!adult && adult) return 1;

        int prefixDiff = prefix - person.prefix;
        if (prefixDiff != 0) return prefixDiff;

        if (expenses != null) {
            int expensesDiff = compareExpenses(person.expenses);
            if (expensesDiff != 0) return expensesDiff;
        }

        return 0;
    }

    private int compareExpenses(int[] expenses) {
        if (this.expenses.length > expenses.length) return -1;
        if (this.expenses.length < expenses.length) return 1;

        for (int i=0; i<this.expenses.length; i++) {
            if (this.expenses[i] > expenses[i]) return -1;
            if (this.expenses[i] < expenses[i]) return 1;
        }
        
        return 0;
    }


}
