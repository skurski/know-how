package know.how.core.exceptions;


import java.io.IOException;

/**
 * A the top we have Throwable class
 * Throwable is extended by Exception and Error class
 * Exception is extended by IOException, InterruptedException, RuntimeException
 * Everything that extends Error and RuntimeException is UncheckedException
 * Everything else is CheckedException
 */
public class CheckedException {

    public static void main (String[] args) {
        if (false)
            throw new OwnUncheckedException();

        if (false)
            throw new OwnUncheckedError();

        try {
            throw new OwnCheckedException();
//            throw new OwnCheckedException2();
        } catch (OwnCheckedException e) {
            e.printStackTrace();
        }

    }
}

class OwnCheckedException extends IOException {
    public void printMessage() {
        System.out.println("Own checked exception.");
    }
}

class OwnCheckedException2 extends Exception {
    public void printMessage() {
        System.out.println("Own checked exception.");
    }
}

class OwnUncheckedException extends RuntimeException {
    public void printMessage() {
        System.out.println("Own unchecked exception.");
    }
}

class OwnUncheckedError extends Error {
    public void printMessage() {
        System.out.println("Own unchecked exception - error.");
    }
}