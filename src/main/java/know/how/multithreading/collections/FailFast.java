package know.how.multithreading.collections;

import java.util.*;


/**
 * Fail-fast iterator means that it fail in fast and clean way
 * ConcurrentModificationException will be thrown if one thread is
 * trying to change collection (add, delete) and other iterate through it
 * <p/>
 * Exception may be thrown also in single threaded environment if we
 * create iterator and during iteration we will try to modify collection
 * using methods of collection not methods of iterator interface
 * <p/>
 * Fail-safe iterator creates a copy of collection and iterate through it
 * No exception but iterator may return not actual data (if other thread
 * change original collection) and it also require to create copy of
 * collection and it takes memory
 */
final class FailFast {
    private static int index = 0;

    private static class SingleThread implements Runnable {
        private final List<String> list;

        SingleThread(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                list.add("Something");
                iter.next();
            }
        }
    }

    private static class One implements Runnable {
        private final Map<Integer, String> map;

        One(Map<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            while (true) {
                map.put(index++, "Some");
                try {
                    Thread.yield();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Two implements Runnable {
        private final Map<Integer, String> map;

        Two(Map<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            while (true) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    entry.setValue("Else");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //Fail-fast in single threaded env
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        Thread t0 = new Thread(new SingleThread(list), "Single Threaded");
        t0.start();
        t0.join();

        //Fail-fast in multithreading env
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Initial");
        map = Collections.synchronizedMap(map);
        Thread t1 = new Thread(new One(map), "Thread One");
        Thread t2 = new Thread(new Two(map), "Thread Two");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.toString());
    }
}

