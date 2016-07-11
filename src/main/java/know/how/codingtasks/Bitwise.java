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
        if ((x & 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean checkIfNumbersHasOppositeSigns(int a, int b) {
        return (a ^ b) < 0; // true if a and b have opposite signs
    }

    public static void testShiftBits() {
        int a = 1;
        System.out.println("Decimal a: " + a + ", binary a: " + Integer.toBinaryString(a));
        int b = a << 4; //16
        int c = b >> 2; // 4

        System.out.println("Decimal b: " + b + ", binary b: " + Integer.toBinaryString(b) + ", decimal c: " + c + ", " +
                "binary c: " + Integer.toBinaryString(c));

        int e = 8;
        System.out.println("Decimal e: " + e + ", binary e: " + Integer.toBinaryString(e));

        int d = -8;
        System.out.println("Decimal d: " + d + ", binary d: " + Integer.toBinaryString(d));

        int f = -8 << 5;
        System.out.println("Decimal f: " + f + ", binary f: " + Integer.toBinaryString(f));
    }

    /**
     * Signed shifts: >> (right shift) , << (left shift)
     * Unsigned shift: >>> (right shift)
     *
     * Right shift: cuts bits from right, moves bits from left to right
     * Left shift: adds bits (0) to right end, moves bits from right to left
     * Signed: Keeps the bits with sign (1 (ones) for negatives and 0 (zeros) for positives)
     * Unsigned: only right, moves bits to right, fill leading bits with zeros (doesn't keep sign)
     */
    public static void testSignedAndUnsignedShift() {
        int a = -8;
        int b = a >> 2;
        int c = a >>> 2;

        System.out.println("Original: " + a + ", -8 >> 2: " + b + ", -8 >>> 2: " + c);
    }

    public static void main(String[] args) {

        swapElements(10, 22);
        System.out.println("Number 367 is odd: " + checkIfNumberIsOdd(367));
        System.out.println("Number 238 is odd: " + checkIfNumberIsOdd(238));

        System.out.println("Number 25 i -34 has opposite signs: " + checkIfNumbersHasOppositeSigns(25, -34));
        System.out.println("Number -34 i -34 has opposite signs: " + checkIfNumbersHasOppositeSigns(-34, -34));

        testShiftBits();

        testSignedAndUnsignedShift();
    }
}
