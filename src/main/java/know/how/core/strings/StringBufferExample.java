package know.how.core.strings;

/**
 * Investigate StringBuffer class.
 * StringBuffer doesn't override equals method.
 */
public class StringBufferExample {

    public static void main(String[] args) {

        // StringBuffer doesn't override equals method
        StringBuffer sb1 = new StringBuffer("some");
        System.out.println(sb1.equals(sb1));

        StringBuffer sb2 = new StringBuffer("some");
        System.out.println("StringBuffers with the same value isn't equal: "
                + sb1.equals(sb2));
    }
}
