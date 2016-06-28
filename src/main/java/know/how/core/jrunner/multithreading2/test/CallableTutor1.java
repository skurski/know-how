package know.how.core.jrunner.multithreading2.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static junit.framework.Assert.assertTrue;

public class CallableTutor1 {
    static StringBuffer buf = new StringBuffer();
    static void log(String s) {
        buf.append(s+"\n");
    }

	public class StringGenerator implements Callable<String> {

		public String call() throws Exception {
        	String[] allStrings = { "Cow", "Goose", "Cat", "Dog", 
        	        "Elephant", "Rabbit", "Snake", "Chicken", 
        	        "Horse", "Human" };
			int index = (int)(Math.random()*100)/10;

			Thread.sleep(10);
			log ("thread is finished:" + allStrings [index]);
			return allStrings[index];
		}
	}
	
	@Test
	public void testCallable() {
		long start = new Date().getTime();
		List<Thread> threads = new ArrayList<Thread>();

		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		/**
		 * We use a pool for 3 threads
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for (int i=0;i<10;i++) {
			results.add(executorService.submit(new StringGenerator()));
		}
		
		/**
		 * We sleep for 15ms to let first 3 tasks to get finished
		 */
		try {
			Thread.sleep(15);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		/**
		 * TODO: Add cancellation of some tasks
		 * Uncomment call of cancel() method.
		 */
		for (int i=0;i<5;i++) {
			log("cancelling thread "+i+", isDone="+results.get(i).isDone());
			//results.get(i).cancel(false);
		}
		
		StringBuilder resultStr = new StringBuilder();
		for(Future<String> result: results){
			try {
				/** TODO: you should check that result 
				* was not cancelled: use isCancelled() 
				*/
				    // The blocking get call
				    resultStr.append(result.get());
				    resultStr.append(" ");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(resultStr);

		long time =new Date().getTime()-start;
		System.out.println("Time of work:"+time);
		
		System.out.println(buf);

		int words = resultStr.toString().split(" ").length;
		assertTrue(words==8);
	}

}
