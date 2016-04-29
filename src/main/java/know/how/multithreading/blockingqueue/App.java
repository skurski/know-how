package know.how.multithreading.blockingqueue;


import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class App {
    private final BlockingQueue<String> queue;
    private final Producer producer;
    private final Consumer consumer;

    public App () {
        this.queue = new ArrayBlockingQueue<>(10);
        this.consumer = new Consumer(queue);
        this.producer = new Producer(queue);
    }

    public final void go () {
        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

        consumerThread.start();
        producerThread.start();


    }

    public static void main (String[] args) {
        App app = new App();
        app.go();

        PriorityQueue<String> prior = new PriorityQueue<>(10);
    }
}
