package know.how.testing.swing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Model {
	private String fileName = "backup.txt";
	
	void writeToFile(Person person) {
		ObjectOutputStream ous = null;
		try {
			ous = new ObjectOutputStream(new FileOutputStream(fileName));
			ous.writeObject(person);
			ous.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ous.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	Person readFromFile() {
		ObjectInputStream ois = null;
		Person person = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			person = (Person) ois.readObject();
		} catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return person;
	}
}
