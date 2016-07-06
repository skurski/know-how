package know.how.core.statements;

public class Loop {
	
	public static void main(String[] args) {
		for(int i=0,j=5; i<10 && j<10; i++, j++) {
			System.out.println(i);
		}
		
		double[] nums = new double[10];
		
		for(double i: nums) {
			System.out.println(i);
		}
		
		String[] strs = new String[10];
		
		for(String i: strs) {
			System.out.println(i);
		}
		
		etykieta:
			while(true) {
				System.out.println("outside loop");
				while(true) {
					System.out.println("inside loop");
					break etykieta;
				}
			}
		
	    test:
	        for (int i = 0; i <= 10; i++) {
	            System.out.println(i + " for outside");
	            int n = 10;
	            while (n-- != 0) {
	                if (n == 5) {
	                	System.out.println(n + " continue");
	                    continue test;
	                }
	            }
	            break test;
	        }
		
	}
}
