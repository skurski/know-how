package know.how.testing.collections;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class IteratorTest {
	private static Set<Integer> set = new TreeSet<Integer>();
	private static Random random = new Random();
	
	public static void go() {
		for (int i=0; i<10; i++) {
			set.add(random.nextInt(100));
		}
		set.add(110);
		
		Iterator<Integer> iter = set.iterator();
		
		while (iter.hasNext()) {
			Integer i = iter.next();
			if (i == 110) iter.remove();
		}
		
		for (Integer i: set) {
			if (i == 110) set.remove(i);
		}
		
		for (Integer i: set) System.out.println(i);
	}
	
	public static void main(String[] args) {
		IteratorTest.go();
	}
}
