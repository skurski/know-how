package know.how.testing.classes;

public class Inherit {
	int z;

	Inherit(int x, int y) {
		z = x + y;
	}
	
}

class Test extends Inherit {
	
	Test(int x, int y) {
		super(x,y);
		z = x + 10;
	}
}
