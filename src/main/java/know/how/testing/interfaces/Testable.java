package know.how.testing.interfaces;


public interface Testable 
{
	enum TestEnum {
		Hi, Ha, Ho;
		
		private int width = 0;
	}
	
	public class Test {
		Test() {
			
		}
		int calc() {
			return 1;
		}
	}
}
