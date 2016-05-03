package know.how.multithreading.concurrency.tasks;


import java.util.ArrayDeque;

/**
 * Concurrency task:
 * 1) Run 2 threads with id equals 1 and 2
 * 2) Threads do some action and then print theirs id
 * 3) Make the id's printed on the screen matching schedule from array
 * 4) Use: synchronized, wait() / notifyAll()
 *
 * @author Piotr Skurski
 */
public class Tours {

    public static void main(String[] args) throws InterruptedException {
        Schedule order = new Schedule();

        Thread one = new QueueThread(1, order);
        Thread two = new QueueThread(2, order);

        one.start();
        two.start();

        one.join();
        two.join();
    }
}

/**
 * Scheduler for threads
 */
class Schedule {
    private ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    private int[] idOrder = {1,2,2,2,1,1,1,2};

    public Schedule() {
        for (int val: idOrder) {
            queue.add(val);
        }
    }

    public synchronized void order(int threadId) {
        if (queue.isEmpty()) {
            Thread.currentThread().interrupt();
            return;
        }

        while (!queue.isEmpty() && queue.peek() != threadId) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (queue.isEmpty()) return;

        System.out.println("Thread id: " + queue.remove());
        notifyAll();
    }
}

class QueueThread extends Thread {
    private int id;
    private Schedule schedule;

    public QueueThread(int number, Schedule order) {
        this.id = number;
        this.schedule = order;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            schedule.order(id);
        }
    }
}



