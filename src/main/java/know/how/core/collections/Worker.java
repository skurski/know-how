package know.how.core.collections;

public class Worker implements Comparable<Worker> {
	private int id;
	private String name;
	private static int counter = 0;
	
	Worker(String name) {
		id = counter++;
		this.name = name;
	}
	
	public int compareTo(Worker w) { 
		if (w == null) return -1;
		if (this == w) return 0;
		int strComp = name.compareTo(w.name);
		if (strComp != 0) return strComp;
		return id - w.id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return String.format("Worker name: %s, id: %d", name, id);
	}
}
