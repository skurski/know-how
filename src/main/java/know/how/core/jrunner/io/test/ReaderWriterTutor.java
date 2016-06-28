package know.how.core.jrunner.io.test;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ReaderWriterTutor {
	private static final String FILES_TEST_PATH = "test.txt";
	private static final String TEST_LINE = "test line";

	/**
	 * Write line TEST_LINE to the file FILES_TEST_PATH, using 
	 * method write of class BufferedWriter.
	 * Then close the stream.
	 */
	public void writeToFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILES_TEST_PATH))) {
			bw.write(TEST_LINE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads line from file by using method readLine() 
	 * of class BufferedReader and returns it
	 * @return
	 */
	public String readFromFile() {
		String text = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILES_TEST_PATH))) {
			text  = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	@Test
	public void testStream() {
		writeToFile();
		String s = readFromFile();
		assertEquals(TEST_LINE, s);
	}
	
	@Before
	public void createFile() {
		File f1 = new File(FILES_TEST_PATH);
		try {
			f1.delete();
			f1.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	
}
