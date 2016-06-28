package know.how.testing.exceptions;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptTest {

	public void doSome() throws IOException {
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file"));
		try {
//			ois.read();
			System.out.println("ois read");
			throw new IOException();
		} finally {
//			ois.close();
			System.out.println("ois close - finally");
		}
	}
	
	// try with resources block - we can declare resources inside parentheses 
	// after try keyword, resource object must implement AutoCloseable interface
	// (Closeable interface extends AutoCloseable interface
	public void tryWithRes() throws FileNotFoundException, IOException {
		try (DataInputStream d = new DataInputStream(new FileInputStream(new File("file")))) {
			
		}
	}
	
	public static void main(String[] args) {
		ExceptTest ex = new ExceptTest();
		try {
			ex.doSome();
			System.out.println("ex.doSome");
		} catch (IOException e) {
			System.out.println("catch e");
		} finally {
			System.out.println("Outside finally!");
		}
		System.out.println("outside everything");
		
	}
}
