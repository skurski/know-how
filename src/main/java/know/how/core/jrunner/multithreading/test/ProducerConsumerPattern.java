package know.how.core.jrunner.multithreading.test;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerPattern {
	private int count;
	
	public synchronized void consume() {
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		System.out.println("Count after consume: " + count);
	}
	
	public synchronized void produce() {
		count++;
		notifyAll();
		System.out.println("Count after produce: " + count);
	}
	
	class Producer implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				produce();
			}
		}
	}
	
	class Consumer implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				consume();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerPattern pcp = new ProducerConsumerPattern();
		Thread producer = new Thread(pcp.new Producer());
		List<Thread> consumers = new ArrayList<Thread>(10);
		
		for (int i=0; i<consumers.size(); i++) {
			consumers.add(new Thread(pcp.new Consumer()));
		}
		
		System.out.println("Starts threads...");
		producer.start();
		producer.join();
		for (Thread t: consumers) {
			t.start();
		}
		
		for (Thread t: consumers) {
			t.join();
		}
	}
}
