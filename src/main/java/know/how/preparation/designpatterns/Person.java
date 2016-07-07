package know.how.preparation.designpatterns;


public class Person implements Comparable<Person>, Greeting {

    private final String name;
    private double salary;
    private int age;
    private final boolean adult;

    private Person(Builder builder) {
        this.name = builder.name;
        this.salary = builder.salary;
        this.age = builder.age;
        this.adult = builder.adult;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;

        Person person = (Person) obj;
        if (!this.name.equals(person.name)) return false;
        if (this.age != person.age) return false;
        if (Double.compare(this.salary, person.salary) != 0) return false;
        if (this.adult != person.adult) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        long temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (adult ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Person person) {
        int salaryDiff =Double.compare(this.salary, person.salary);
        if (salaryDiff != 0) return salaryDiff;
        int ageDiff = age - person.age;
        if (ageDiff != 0) return ageDiff;
        int nameDiff = name.compareTo(person.name);
        if (nameDiff != 0) return nameDiff;
        return (adult == person.adult) ? 0 : (adult ? 1 : -1);
    }

    @Override
    public String print() {
        return "Standard print...";
    }

    public static class Builder {
        private final String name;
        private double salary;
        private int age;
        private final boolean adult;

        public Builder(final String name, final boolean adult) {
            this.name = name;
            this.adult = adult;
        }

        public Builder setSpecs(final int age, final double salary) {
            this.age = age;
            this.salary = salary;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", adult=" + adult +
                '}';
    }
}