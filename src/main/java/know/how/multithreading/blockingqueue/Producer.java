package know.how.multithreading.blockingqueue;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

public final class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final Random random;
    private final String[] values = {
          "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten"
    };

    public Producer (BlockingQueue queue) {
        this.queue = queue;
        random = new Random();
    }

    @Override
    public void run () {
        int i = 0;
        while (i < 20) {
            try {
                queue.put(values[random.nextInt(10)]);
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
