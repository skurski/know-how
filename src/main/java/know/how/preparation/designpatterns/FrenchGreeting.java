package know.how.preparation.designpatterns;


public class FrenchGreeting implements Greeting {

    private Person person;

    public FrenchGreeting(Person person) {
        this.person = person;
    }

    @Override
    public String print() {
        String msg = person.print();
        msg += " french super hyper extension...";
        return msg;
    }
}
