package know.how.codingtasks;

/**
 * Swap two variables with int value without using temporary variable
 */
public class Swap {

    public static void swapIntWithoutTempVar() {
        int x = 1;
        int y = 3;
        System.out.println("Before swapping => x: " +x+ ", y: " + y);

        // using temp variable
//        int temp = x;
//        x = y;
//        y = temp;

        // using arithmetic operator (addition)
        x = x + y; // x=4
        y = x - y; // y=1
        x = x - y; // x=3
        System.out.println("After swapping with arithmetic => x: " + x + ", y: " + y);

        // using bitwise operator (XOR)
        // x = 3 => 0010
        // y = 1 => 0001
        x = x ^ y; // 0011
        y = x ^ y; // 0010
        x = x ^ y; // 0001
        System.out.println("After swapping with XOR => x: " + x + ", y: " + y);

        // using division and multiplication
        // x = 1
        // y = 3
        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("After swapping with * and / => x: " + x + ", y: " + y);
    }

    public static void main (String[] args) {
        swapIntWithoutTempVar();
    }
}
