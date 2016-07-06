package know.how.core.interfaces;


public class CheckInterface implements InterfaceTest {

    public CheckInterface() {
        InterfaceTest.Some some = new InterfaceTest.Some();
        System.out.println(some.getX());
    }

    public static void main(String[] args) {
        new CheckInterface();
    }
}
