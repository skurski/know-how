package know.how.core.jrunner.multithreading2.test;

import org.junit.Test;

public class VolatileTest {
    // Variable running should be volatile
	volatile boolean running = true;

    static StringBuffer buf = new StringBuffer();
    static void log(String s) {
        buf.append(s+"\n");
    }

	@Test
	public void testVolatile() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				int counter = 0;
				while (running) {
					counter++;
				}
				log("Thread 1 finished. Counted up to "
						+ counter);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// Sleep for a bit so that thread 1 has a chance to start
				try {
					Thread.sleep(100);
				} catch (InterruptedException ignored) {
				}
				log("Thread 2 finishing");
				running = false;
			}
		});
		
		t1.start();
		t2.start();
		
		try {
		    t1.join();
		    t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(buf);
	}

}
