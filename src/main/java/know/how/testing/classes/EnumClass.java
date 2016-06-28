package know.how.testing.classes;

/*
 * Enum - we can declare enum in top-level class, interface
 * and inside nested static class and of course as standalone class
 * 
 * Cannot in inner class
 */
public class EnumClass {
	Operations oper;
	
	EnumClass(Operations o) {
		oper = o;
	}
	
	int calculate(int x, int y) {
		return oper.MULTI.calculate(x, y);
	}
	
	public static void main(String[] args) {
		EnumClass e = new EnumClass(Operations.MULTI);
		System.out.println(e.calculate(10, 10));
	}
	
	public static class EnumTest {
		public enum Day {
			MON, THU, WED, FRI																																																																																							
		}
	}

}

enum Operations {
	MULTI("*"),
	DIVIDE("/"),																																													
	ADD("+"),
	SUB("-");																																																																																																																		
	
	private String op = null;
	
	Operations(String sign) {
		op = sign;
	}
	
	int calculate(int x, int y) {
		switch(op) {
			case "+": return x + y;
			case "-": return x - y;
			case "*": return x * y;
			case "/": return x / y;
			default: return 0;
		}
	}
}
