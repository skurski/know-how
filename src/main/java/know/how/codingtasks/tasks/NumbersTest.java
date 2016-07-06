package know.how.codingtasks.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersTest {
	private int maxInt;
	private int minInt;
	
	@Before
	public void initNumbers() {
		maxInt = Integer.MAX_VALUE;
		minInt = Integer.MIN_VALUE;
	}

	@Test
	public void testAddInt() {
		
		assertEquals("bad result", 10d, Numbers.addInt(maxInt, minInt), 0d);
	}

}
