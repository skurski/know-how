package know.how.testing.exceptions;


public class MethodStackTrace {
    public static void main (String[] args) {
        System.out.println("main method");
        methodA();
    }

    public static void methodA () {
        System.out.println("method A");
        methodB();
    }

    public static void methodB () {
        System.out.println("method B");
        methodC();
    }

    public static void methodC () {
        System.out.println("method C throw exception");
        int y = 22 / 0; // throw ArithmeticException
    }
}
