package know.how.testing.exceptions;


import java.io.FileOutputStream;

public class TryWithResources {

    public static void main (String[] args) throws Exception {

        // with Try with resources we can use only try block
        // before we have to add catch or finally block
        try (FileOutputStream in = new FileOutputStream("data");
             CloseableResource res = new CloseableResource()) {

            // do something with file

            res.start();

        }
    }
}

class CloseableResource implements AutoCloseable {

    public void start() {
        System.out.println("Start custom resource.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close custom resource!");
    }
}
