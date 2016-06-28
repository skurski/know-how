package know.how.core.jrunner.collections.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class LinkedOrArrayListTutor {
	long start;

	String[] animals = { "Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit",
			"Snake", "Chicken", "Horse", "Human" };

	ArrayList<String> arrayList = new ArrayList<String>();
	LinkedList<String> linkedList = new LinkedList<String>();

	public String getRandomAnimal() {
		int index = (int) (Math.random() * animals.length);
		return animals[index];
	}

	public void addAnimalsToList() {
		arrayList.add(getRandomAnimal());
	}

	public void nextTimeLog(String st) {
		log("Time of work for " + st + ": " + (new Date().getTime() - start));
		start = new Date().getTime();
	}

	@Test
	public void testList() {
		start = new Date().getTime();
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(getRandomAnimal());
		}
		nextTimeLog("arrayList add");

		for (int i = 0; i < 1000000; i++) {
			linkedList.add(getRandomAnimal());
		}
		nextTimeLog("linkedList add");

		for (int i = 0; i < 100000; i++) {
			arrayList.get(1000);
		}
		nextTimeLog("arrayList get()");

		for (int i = 0; i < 100000; i++) {
			linkedList.get(1000);
		}
		nextTimeLog("linkedList get()");

		for (int i = 0; i < 1000; i++) {
			arrayList.remove(1000);
		}
		nextTimeLog("arrayList remove()");

		for (int i = 0; i < 1000; i++) {
			linkedList.remove(1000);
		}
		nextTimeLog("linkedList remove()");

		for (int i = 0; i < 1000; i++) {
			arrayList.add(1000, "Dinosaur");
		}
		nextTimeLog("arrayList insert in the middle");

		for (int i = 0; i < 1000; i++) {
			linkedList.add(1000, "Dinosaur");
		}
		nextTimeLog("linkedList insert in the middle");

		for (int i = 0; i < 100; i++) {
			arrayList.contains("Dinosaur1");
		}
		nextTimeLog("arrayList contains");

		for (int i = 0; i < 100; i++) {
			linkedList.contains("Dinosaur1");
		}
		nextTimeLog("linkedList contains");
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
}
