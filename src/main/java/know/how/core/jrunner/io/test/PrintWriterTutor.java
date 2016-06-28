package know.how.core.jrunner.io.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PrintWriterTutor {

	private static final String FILE_OUT = "std.out";
	PrintStream out;
    PrintStream originalOut = new PrintStream(System.out);
    
	public void redirectOut() {
		try {
			out = new PrintStream(FILE_OUT);
			System.setOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void printlnData() {
		System.out.println("output test");		
	}
	
	@Test
	public void testOutToFile() {
		redirectOut();
		printlnData();

		BufferedReader stdOut;
		try {
			stdOut = new BufferedReader(new FileReader(FILE_OUT));
			String line = stdOut.readLine();
			System.setOut(originalOut);
			assertEquals("output test", line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

