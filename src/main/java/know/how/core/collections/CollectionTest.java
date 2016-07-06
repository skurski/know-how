package know.how.core.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {
	private Set<Worker> workers = new TreeSet<Worker>();
	
	void addWorkers() {
		String alf = "qazwsxedcrfvtgbyhnujmiklop";
		Random rand = new Random();
		
		for (int i=0; i<100; i++) {
			int start = rand.nextInt(15);
			workers.add(new Worker(alf.substring(start,20)));
		}
		System.out.println("Numbers of workers: " + workers.size());
		
		Iterator<Worker> iter = workers.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == 99) {
				iter.remove();
			}
		}
		
		for (Worker w : workers) System.out.println(w);
		System.out.println("Numbers of workers: " + workers.size());
		
		Worker min = Collections.max(workers, new Comparator<Worker>() {
			public int compare(Worker w1, Worker w2) {
				if (w1 == w2) return 0;
				return w1.getId() - w2.getId();
			}
		});
		
		System.out.println(min);
	}
	
	public static void main(String[] args) {
		CollectionTest col = new CollectionTest();
		col.addWorkers();
	}
}
