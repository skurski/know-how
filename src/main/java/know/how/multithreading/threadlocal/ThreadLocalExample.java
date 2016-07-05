package know.how.multithreading.threadlocal;

/**
 * The ThreadLocal class enables you to create variables that can only be read and written by the same thread, even
 * if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, then the two
 * threads cannot see each other's ThreadLocal variables
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        // each thread access their own ThreadLocal instance
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
