package know.how.testing.classes;

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
//		Over2 o = new Over2();
//		o.get();
		
		Overload o = new Overload("s");
	}
	
}

//class Over2 extends Overload {
//	
////	Over2(String s) {
////		super(s);
////	}
//	
//	void get() {
//		System.out.println("testing...");
//	}
//	
//}
