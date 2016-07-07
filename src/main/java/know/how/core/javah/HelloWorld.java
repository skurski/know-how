package know.how.core.javah;

/**
 * JDK libraries: (JDK/bin)
 *
 * javac - compiler
 * javah - create header C file from java .class file (and C source file), used to create native methods, use with JNI
 * javap - print information about java class (from compiled .class file)
 * javadoc - create documentation
 */
public class HelloWorld {

    static {
        System.loadLibrary("HelloWorld");
    }

    private native void print();

    public static void main(String[] args) {
        new HelloWorld().print();
    }
}
