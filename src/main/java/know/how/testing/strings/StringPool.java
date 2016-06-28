package know.how.testing.strings;

public class StringPool {
    // "new" will always create new string (unique)
    public static String someNew = new String("newString");

    // string literal, jvm looks if such string exists
    // in the string literal pool, if exists return the reference,
    // if not create new one and put in string literal pool
    public static String someLiteral = "literalString";
	
	public static void main(String[] args) {
		String checkNew = "newString";

        String checkLiteral = "literalString";

		if (someNew != checkNew) {
			System.out.println("String create with new is not the same.");
		}

        if (someLiteral == checkLiteral) {
            System.out.println("String create with string literal is" +
                    " return from jvm string pool.");
        }

        // print "ej"
        System.out.println(new String("heja").substring(1,3));

        // StringBuilder and StringBuffer
        // Implements Appendable, does not override equals method
        // In StringBuffer methods are synchronized
        StringBuilder sb = new StringBuilder("heja");
        StringBuilder sb2 = new StringBuilder("heja");

        if (!sb.equals(sb2)) {
            System.out.println("String Builder i Buffer don't override" +
                    " equals method so only compare references.");
        }

        new StringBuffer();
	}
}
