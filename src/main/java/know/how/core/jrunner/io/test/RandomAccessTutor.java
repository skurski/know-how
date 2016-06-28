package know.how.core.jrunner.io.test;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class RandomAccessTutor {
	
	private static final String FILES_TEST_PATH = "test.txt";

	/**
    * The method should open the file RandomAccessFile on path FILES_TEST_PATH
    * And write there the number 10 (type Integer), and then the string "test line"
    */
	public void randomAccessWrite() {
		try {
			RandomAccessFile raf = new RandomAccessFile(FILES_TEST_PATH, "rw");
			raf.writeInt(15);
			raf.writeChars("test line");
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
    * The method should open the file RandomAccessFile on path FILES_TEST_PATH,
    * skip the number 10 and the word "test" (without reading them),
    * jump to the fifth letter, read and return the string "line"
    */
	public String randomAccessRead() {
		String text = null;
		try {
			RandomAccessFile raf = new RandomAccessFile(FILES_TEST_PATH, "rw");
			raf.seek(14);
			text = raf.readLine();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
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
	
	@Test
	public void testRandomAccess() throws UnsupportedEncodingException  {
		randomAccessWrite();
		String s = null;
		int i=-1;
		try {
			RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "r");
			i = f.readInt();
			s = f.readLine();
			f.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertEquals(i, 15);
		s = new String(s.getBytes("UTF-8"), "Unicode");
		assertEquals("test line", s);
		String read = randomAccessRead();
		read = new String(read.getBytes("UTF-8"), "Unicode");	
		assertEquals("line", read);
	}
}

