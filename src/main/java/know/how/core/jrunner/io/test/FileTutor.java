package know.how.core.jrunner.io.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileTutor {

	/**
    * The method must create a folder and file test.txt inside it 
    * - the file test/test.txt
    * Also, output in the full path to the log file you created
    */
	public void createFile() {
		File file = new File("test/test.txt");
		file.getParentFile().mkdir();
		try {
			file.createNewFile();
			log(file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
    * This method should remove the folder and test file test / test.txt
    */
	public void deleteFile() {
		File file = new File("test/test.txt");
		file.delete();
		file.getParentFile().delete();
	}
	
	
	@Test
	public void testCreateFile() {
		createFile();
		File f = new File("test/test.txt");
		assertTrue(f.exists());
	}
	
	@Test
	public void testDeleteFile() {
		deleteFile();
		File f = new File("test/test.txt");
		assertFalse(f.exists());
		assertFalse(new File("test").exists());
	}

	private void log(Object str) {
		System.out.println(str);
	}

}

