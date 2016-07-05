package know.how.core.immutable;

import java.util.Arrays;
import java.util.List;

/**
 * Test immutable objects.
 */
public class ImmutableTest {

    public static void main(String[] args) throws InterruptedException {
        //mutable object
        MutableList mutableList = new MutableList("Mutable List");
        //immutable object
        ImmutableList immutableList = new ImmutableList("Immutable List");

        /** ------------ Mutable test ---------------------- */
        Thread[] threads = new Thread[5];
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new Task(i, mutableList.getValues()));
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println("Mutable list: " + Arrays.toString(mutableList.getValues().toArray()));

        /** ------------ Immutable test -------------------- */
        Thread[] threads2 = new Thread[5];
        for (int i=0; i<threads2.length; i++) {
            threads2[i] = new Thread(new Task(i, immutableList.getValues()));
        }
        for (Thread thread : threads2) {
            thread.start();
            thread.join();
        }
        List<String> modifyList = immutableList.setValue(0, "One more modification");
        System.out.println("Immutable list: " + Arrays.toString(immutableList.getValues().toArray()));
        System.out.println("Modify list: " + Arrays.toString(modifyList.toArray()));
    }
}

class Task implements Runnable {
    private List<String> values;
    private final int id;

    public Task(int i, List<String> values) {
        this.id = i;
        this.values = values;
    }

    @Override
    public void run() {
        values.set(0, "Modify by " + id);
    }
}
