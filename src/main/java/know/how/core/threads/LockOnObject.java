package know.how.core.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LockOnObject {
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	private Random random = new Random();
	
	public void doStuffOnList1() {
		synchronized(lock1) {
			try {
				Thread.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public void doStuffOnList2() {
		synchronized(lock2) {
			try {
				Thread.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for (int i=0; i<1000; i++) {
			doStuffOnList1();
			doStuffOnList2();
		}
	}
	
	public void main() {
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		
		Thread[] threads = new Thread[2];
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					process();
				}
			});
		}
		for (Thread t: threads) t.start();
		for (Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Take time: " + (end-start));
		System.out.println("The list1 size is " + list1.size() + ", the list2 is " + list2.size());
	}
	
	public static void main(String[] args) {
		LockOnObject l = new LockOnObject();
		l.main();
	}
}
