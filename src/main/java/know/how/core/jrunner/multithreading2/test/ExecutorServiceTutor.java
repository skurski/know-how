package know.how.core.jrunner.multithreading2.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ExecutorServiceTutor {
	Object lock = new Object();
	Set<String> currentThreads = new HashSet<String>();

    static StringBuffer buf = new StringBuffer();
    static void log(String s) {
        buf.append(s+"\n");
    }

	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void logCurrentThreads() {
    	StringBuilder currentThreadsStr = new StringBuilder();
    	// create 
    	List<String> threads = new ArrayList<>(currentThreads);
		for (String str : threads) {
			currentThreadsStr.append(str).append(", ");
		}
		log("size:"+currentThreads.size()+
				", current thread pool: "+currentThreadsStr.toString());
	}
	
	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
		    /**
		     * We add the thread to the list of executing threads
		     * currentThreads, do some job (sleep to imitate it)
		     * and then remove thread after finish.
		     */
			currentThreads.add(threadName);
			logCurrentThreads();
			sleep(10);
			currentThreads.remove(threadName);
			logCurrentThreads();
		}
	}
	
	@Test
	public void testThread() {
		long start = new Date().getTime();

		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<10;i++) {
			threads.add(new Thread(new TestThread("t"+i)));
		}

//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0;i<10;i++) {
			executorService.execute(threads.get(i));
//			executorService.submit(threads.get(i)); //alternatively
		}
		
		executorService.shutdown();
		try {
			executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
			//executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdownNow();

		long time =new Date().getTime()-start;
		System.out.println("Time of work:"+time);
        System.out.println(buf);
		
		/**
		 * There shouldn't be threads in currentThreads list after 
		 * successful finishing.
		 */
        assertTrue(currentThreads.size()==0);

        /**
         * We should use multhithreading to improve perfomance
         */
        assertTrue(time<100);
	}

}
