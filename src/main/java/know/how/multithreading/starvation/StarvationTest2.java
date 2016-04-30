package know.how.multithreading.starvation;


public class StarvationTest2 {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    // No livelock, but Thread 1 is working most of the time
    public static void main(String args[]) {

        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T2.setPriority(Thread.MIN_PRIORITY);
        T1.setPriority(Thread.MAX_PRIORITY);
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            while (true) {
                synchronized (Lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 2...");
                    synchronized (Lock2) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                    System.out.println("Thread 1: Realises locks.");
                }
            }
        }
    }

    private static class ThreadDemo2 extends Thread {
        public void run() {
            while (true) {
                synchronized (Lock1) {
                    System.out.println("Thread 2: Holding lock 2...");

                    System.out.println("Thread 2: Waiting for lock 1...");
                    synchronized (Lock2) {
                        System.out.println("Thread 2: Holding lock 1 & 2...");
                    }
                }
                System.out.println("Thread 2: Realises locks.");
            }
        }
    }
}
