package know.how.core.exceptions;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by pskurski on 6/20/2016.
 */
public class TryCatchFinally {

    public static void testTryCatchFinally() {
        try {
            System.out.println("Try block...");
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Exception is caught: " + e);
        } finally {
            System.out.println("Finally is executed...");
        }
    }

    public static void testTryFinally() throws IllegalArgumentException {
        try {
            System.out.println("Try block...");
            throw new IllegalArgumentException();
        } finally {
            System.out.println("Finally is executed...");
        }
    }

    public static void testTryWithRes() throws Exception {
        try (FileInputStream fis = new FileInputStream(new File("file"))) {

        }
    }

    public static void testTryWithUncheckedException() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("We don't need catch block or throws because it is unchecked exception.");
        }
    }

    public static void main(String[] args) {
        TryCatchFinally.testTryCatchFinally();

        System.out.println("---------------------------");

        try {
            TryCatchFinally.testTryFinally();
        } catch (Exception e) {
            System.out.println("Exception is caught: " + e);
        }

        System.out.println("---------------------------");

        TryCatchFinally.testTryWithUncheckedException();
    }
}
