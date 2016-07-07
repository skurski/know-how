package know.how.preparation.designpatterns;


public class Test {

    public static void main(String[] args) {

        Person person = new Person.Builder("Peter", true).setSpecs(34, 4673.95).build();

        System.out.println(person.print());

        System.out.println(new FrenchGreeting(person).print());
    }
}
