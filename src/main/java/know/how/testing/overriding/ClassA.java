package know.how.testing.overriding;


import java.io.IOException;
import java.sql.SQLException;

public class ClassA {

    void methodA(String str) throws IOException {
        System.out.println("method A of ClassA.");
    }

    int someMethod(double num, String str) {
        System.out.println("original method: someMethod");
        return 1;
    }

    //Overload
    private void someMethod(double num, int p) throws IOException {
        System.out.println("Overload someMethod.");
    }

    //Overload
    public final String someMethod(boolean bool) throws IllegalArgumentException {
        System.out.println("Another overload of someMethod.");
        return "done";
    }

    public static void main(String[] args) throws IOException {
        new ClassA().methodA("str");
        new ClassB().methodA("str");
        new ClassB().methodB(10);
        new ClassB().someMethod(false);
        new ClassB().someMethod(100l);
    }
}

class ClassB extends ClassA implements InterfaceA {

    @Override
    void methodA(String str) throws IllegalArgumentException {
        System.out.println("method A of ClassB, without throws part.");
    }

    @Override
    public void methodB(int num) {
        System.out.println("Override interface method, without throws part.");
    }

    //Overload
    boolean someMethod(Long num) {
//        super.someMethod(true);
        System.out.println("Overload method of subclass.");
        return false;
    }
}

interface InterfaceA {
    void methodB(int num) throws SQLException;
}
