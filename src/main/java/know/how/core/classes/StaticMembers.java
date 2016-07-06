package know.how.core.classes;

public class StaticMembers {
	public static int total = 10;
	public static int test;
	public int local;
	
	public StaticMembers() {
		int temp = this.total;
		System.out.println(temp);
	}
	
	void localMethod() {
		local = 10;
		assert 10 != local : "mistake";
		
		class Test {
			
		}

	}
	
	public static void main(String[] args) {
		StaticMembers sm = new StaticMembers();
		sm.localMethod();
		System.out.println(test);
		int i; 
		while (true) {
			break;
		}
		i = 40;
		System.out.println(i);
		double d = 3.2d;
	}
}
