package know.how.testing.classes;

import java.util.Comparator;

abstract class AbstractTest {

    Comparator<String> com = new Comparator<String>(){
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    };
	
	public AbstractTest() {
		
	}

    abstract void some();
}

class Sub extends AbstractTest {
	// make the parent constructor private

    void some() {

    }
}
