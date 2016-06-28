package know.how.core.jrunner.io.test;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DataStreamTutor {
	private static final String FILES_TEST_PATH = "test.txt";
	private static final String TEST_LINE = "test line";

	/**
    * Writes a string TEST_LINE to the file FILES_TEST_PATH, using
    * method writeUTF of class DataOutputStream.
    * Also use BufferedOutputStream for buffering.
    * Then close the stream.
    */
	public void writeToFile() {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(FILES_TEST_PATH)));
			dos.writeUTF(TEST_LINE);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
    * Reads a line from a file using the method readUTF and returns it.
    * @return
	*/
	public String readFromFile() {
		DataInputStream dis = null;
		String text = null;
		try {
			dis = new DataInputStream(
				new BufferedInputStream(
					new FileInputStream(FILES_TEST_PATH)));
			text = dis.readUTF();
			dis.close();
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

