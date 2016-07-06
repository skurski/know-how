package know.how.core.finalvariables;

public class TestFinalVariable extends Thread {
	static int i = 0;

	public void run() {
		i++;
		System.out.println("i=" + i);
		FinalVariable fv = new FinalVariable();
		fv.valueOfFinalVariable();
	}

	public static void main(String args[]) {
		Thread t = new TestFinalVariable();
		Thread t1 = new TestFinalVariable();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
	}
}

class FinalVariable {
	private static final String var = "this cannot be changed "
			+ TestFinalVariable.i;

	public void valueOfFinalVariable() {
		System.out.println(var);
	}
}