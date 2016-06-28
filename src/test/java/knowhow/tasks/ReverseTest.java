package knowhow.tasks;


import know.how.codingtasks.Reverse;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ReverseTest {
    int[] testArray;
    String str;

    @Before
    public void setUp() {
        int length = Integer.MAX_VALUE / 50;
//        length = 1000;
        testArray = new int[length];
        for (int i=0; i<length; i++) {
            testArray[i] = i;
        }

        str = "Poszedlem do domu spac i nie moglem rano wstac!";
    }

    @Test
    public void whileReverseTest() {
        Reverse.halfArrayReverse(testArray);
        Reverse.halfArrayReverse(testArray);
        Reverse.halfArrayReverse(testArray);
        assertTrue(true);
    }

    @Test
    public void forReverseTest() {
        Reverse.wholeArrayReverse(testArray);
        Reverse.wholeArrayReverse(testArray);
        Reverse.wholeArrayReverse(testArray);
        assertTrue(true);
    }

    @Test
    public void reverseStringTest() {
        String res = Reverse.stringReverse(str);
        System.out.println(res);
        assertTrue(true);
    }

    @Test
    public void rawReverseStringTest() {
        String res = Reverse.rawStringReverse(str);
        System.out.println(res);
        assertTrue(true);
    }
}
