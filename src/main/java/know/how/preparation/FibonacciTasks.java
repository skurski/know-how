package know.how.preparation;

/**
 * Created by psk on 03.07.16.
 */
public class FibonacciTasks {

    public static long getFibonacciValueForNElement(int element) {
        if (element < 0) {
            throw new IllegalArgumentException(""+element);
        }
        if (element == 0) {
            return 0;
        }
        if (element == 1 || element == 2) {
            return 1;
        }

        long result = 2l;
        long fprev = 1;
        long fprevprev = 1;
        for (int i=3; i<=element; i++) {
            result = fprev + fprevprev;
            fprevprev = fprev;
            fprev = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getFibonacciValueForNElement(67));

        label:
        for (int i=0; i<10; i++) {
            System.out.println("continue " + i);
            for (int j=0; j<10; j++) {
                System.out.println("works");
                continue label;
            }
            System.out.println("Not possible to get here.");
        }

        System.out.println("After break.");
    }
}
