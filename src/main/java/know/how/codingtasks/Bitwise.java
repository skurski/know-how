package know.how.codingtasks;

/**
 * Tricks that can be done with Bitwise operators.
 * Bitwise operations in java:
 * & -> AND
 * ^ -> XOR
 * | -> OR
 * ~ -> NOT
 * a >> b -> right shift, a = bit pattern, b = number of positions to shift
 * a << b -> left shift
 */
public class Bitwise {

    public static void swapElements(int a, int b) {
        System.out.println("Original: a=>"+a+", b=>"+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Swap: a=>"+a+", b=>"+b);
    }

    /**
     * Every odd number has the oldest bit == 1 and even number has the oldest bit == 0.
     *
     * @param x
     * @return
     */
    public static boolean checkIfNumberIsOdd(int x) {
        if ((x & 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkIfNumbersHasOppositeSigns(int a, int b) {

        return (a ^ b) < 0; // true if a and b have opposite signs
    }

    public static void main(String[] args) {

        swapElements(10, 22);
        System.out.println("Number 367 is odd: " + checkIfNumberIsOdd(367));
        System.out.println("Number 238 is odd: " + checkIfNumberIsOdd(238));

        System.out.println("Number 25 i -34 has opposite signs: " + checkIfNumbersHasOppositeSigns(25, -34));
        System.out.println("Number -34 i -34 has opposite signs: " + checkIfNumbersHasOppositeSigns(-34, -34));

        //shift
        int a = 1;
        int b = a << 4;
        System.out.println("b: " + b);
    }
}
