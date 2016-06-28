package know.how.core.jrunner.multithreading2.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueTutor {
    static StringBuffer buf = new StringBuffer();

	PriorityBlockingQueue<Order> orderQueue = 
			new PriorityBlockingQueue<Order>();
	
	class Order implements Comparable<Order> {
		public String title;
		public boolean priority;

		@Override
		public String toString() {
			return "Order " + title + ", priority=" + priority;
		}

		public Order(String title, boolean priority) {
			super();
			this.title = title;
			this.priority = priority;
		}

		@Override
		public int compareTo(Order o) {
		      Boolean o1 = new Boolean(this.priority);
		      Boolean o2 = new Boolean(o.priority);
		      
		      return o2.compareTo(o1);
		}
		
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class AddOrderThread implements Runnable {
		@Override
		public void run() {
			orderQueue.put(new Order("books",false));
			sleep(10);
			orderQueue.put(new Order("table",false));
			sleep(10);
			orderQueue.put(new Order("computer",true));
			sleep(10);
			orderQueue.put(new Order("dog",false));
		}
	}
	
	class ReadOrderThread implements Runnable {
		int orderNum = 0;
		@Override
		public void run() {
			while(orderNum<4) {
				try {
					Order order = orderQueue.take();
					// check that first taken order has priority==true 
					if (order.priority && orderNum==0) priorityAhead = true;
					log(order.toString());
					orderNum++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
    static void log(String s) {
        buf.append(s+"\n");
    }
	
	boolean priorityAhead = false;
	
	@Test
	public void testName() throws Exception {
		Thread addOrderThread = new Thread(new AddOrderThread());
		Thread readOrderThread = new Thread(new ReadOrderThread());
		addOrderThread.start();
		/**
		 * TODO: we should wait while orders will appear in the list,
		 * otherwise we will read orders in order it was added to the queue
		 */
		Thread.sleep(100);
		readOrderThread.start();
		
		addOrderThread.join();
		readOrderThread.join();
		
		System.out.print(buf);
		Assert.assertTrue("Order marked as priority should be the first", 
		    priorityAhead);
	}
}

