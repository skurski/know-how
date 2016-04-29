package know.how.multithreading.blockingqueue;


import java.util.concurrent.BlockingQueue;

public final class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer (BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run () {
        while (true) {
            try {
                String str = queue.take();
                System.out.println("Consumer take: " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}