package know.how.multithreading.executor;

import java.util.concurrent.*;

/**
 * ExecutorService framework
 * Allows to submit runnable (callable) tasks and execute them
 * using fixed number of threads (thread pool)
 * <p/>
 * Executor interface has one method: execute(Runnable)
 * <p/>
 * ExecutorService interface has more methods, for example:
 * submit(Runnable), submit(Callable), shutdown(), awaitTermination(int timeout, unit),
 * shutdownNow() => stop executing tasks, return list of awaiting tasks
 * <p/>
 * submit method return Future object, Future<V> for Callable object
 * method get() of Future return null (for runnable) and value for callable
 */
final class ThreadPool {

    private static class JobRun implements Runnable {
        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                Thread.yield();
                System.out.println("JobRun running...");
                i--;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        }
    }

    private static class JobCall implements Callable<String> {
        @Override
        public String call() {
            int i = 10;
            while (i > 0) {
                Thread.yield();
                System.out.println("JobCall calling...");
                i--;

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
            return "OK call method return.";
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future jobRun = executor.submit(new JobRun());
        Future<String> jobCall = executor.submit(new JobCall());
        Future awaitingTask = executor.submit(new JobRun());
        executor.shutdown();

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Future for Runnable return null: " + jobRun.get());
            System.out.println("Future<V> for Callable return value: " + jobCall.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
