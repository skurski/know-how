package know.how.core.jrunner.multithreading.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import static org.junit.Assert.assertEquals;

public class PipedReaderWriterTutor {
	private static final String TEST_LINE = "test line";
	PipedWriter pipedWriter = new PipedWriter();
	PipedReader pipedReader;
	String pipeReaderResult = null;
	Object waiter = new Object();
	
	class PipeWriterThread implements Runnable {
		public void run() {
			BufferedWriter out = new BufferedWriter(pipedWriter);
			try {
				out.write(TEST_LINE);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class PipeReaderThread implements Runnable {
		public void run() {
			BufferedReader in = new BufferedReader(pipedReader);
			try {
				pipeReaderResult = in.readLine();
				synchronized (waiter) {
					waiter.notify();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@Test
	public void testPipe() throws InterruptedException {
		try {
			pipedReader = new PipedReader(pipedWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(new PipeWriterThread()).start();
		new Thread(new PipeReaderThread()).start();
		
		synchronized (waiter) {
			waiter.wait();
		}

		assertEquals(TEST_LINE, pipeReaderResult);
	}
	
}

