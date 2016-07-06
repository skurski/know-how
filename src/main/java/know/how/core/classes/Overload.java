package know.how.core.classes;

public class Overload {
	
//	public Overload() {}
	
	public Overload(String s) {
		
	}
	
	
	public void over(int i) {
		
	}
	
	public void over(String s) {

	}
	
	public double over(double d) {
		 return d;
	}
	
	public static void main(String[] args) {
		Over2 o = new Over2("a");
		o.get();
		
		Overload obj = new Overload("s");
	}
	
}

class Over2 extends Overload {

	Over2(String s) {
		super(s);
	}

	void get() {
		System.out.println("testing...");
	}

}
