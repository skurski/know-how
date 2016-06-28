package know.how.core.jrunner.multithreading.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SynchronizedTutor {
    static StringBuffer buf = new StringBuffer();
    Object lock = new Object();
	Integer counter = 0;
	
    static void log(String s) {
        buf.append(s+"\n");
    }

	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<1000;i++) {
				synchronized (lock) {
					counter++;
					log(threadName+":"+i+":"+counter);
				}
			}
		}
	}
	
	@Test
	public void testThread() {
		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<1000;i++) {
			threads.add(new Thread(new TestThread("t"+i)));
		}
	    System.out.println("Starting threads");
		for (int i=0;i<1000;i++) {
			threads.get(i).start();
		}
	    System.out.println("Waiting for threads");
	    try {
			for (int i=0;i<1000;i++) {
				threads.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Uncomment this to look how counter is changing
		//System.out.println(buf);
		System.out.println("counter="+counter);
		assertTrue(counter==1000000);
	}

}
