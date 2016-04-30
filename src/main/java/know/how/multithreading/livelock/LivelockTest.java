package know.how.multithreading.livelock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LivelockTest {
    public static void main(String[] args) {
        Lock p = new ReentrantLock();
        Lock n = new ReentrantLock();
        Thread t1 = new Thread(new One(p, n));
        Thread t2 = new Thread(new Two(n, p));
        t1.start();
        t2.start();
    }
}

class One implements Runnable {
    Lock p;
    Lock n;

    public One(Lock p, Lock n) {
        this.p = p;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            p.lock();
            try {
                System.out.println("Locked p");
                while (!n.tryLock()) {
                    System.out.println("n is locked. Try to get n");
                }
                System.out.println("Locked n");
                n.unlock();
            } finally {
                p.unlock();
            }

        }
    }
}

class Two implements Runnable {
    Lock p;
    Lock n;

    public Two(Lock n, Lock p) {
        this.p = p;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            n.lock();
            try {
                System.out.println("Locked n");
                while (!p.tryLock()) {
                    System.out.println("p is locked. Try to get p");
                }
                System.out.println("Locked p");
                p.unlock();


            } finally {
                n.unlock();
            }
        }
    }
}
