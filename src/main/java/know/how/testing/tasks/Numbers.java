package know.how.testing.tasks;

public class Numbers {
    public static double addInt(int a, int b) {
    	if (a > Integer.MAX_VALUE /2 || b > Integer.MAX_VALUE/2) {
    		long res = (long) a + (long) b;
    		return (double) (res /2);
    	} 
    	if (a < Integer.MIN_VALUE /2 || b < Integer.MIN_VALUE/2) {
    		long res = (long) a + (long) b;
    		return (double) (res /2);
    	}     	
    	return (double) ((a + b) /2);
    }
    
    public static void main(String[] args) {
        double x = Numbers.addInt(Integer.MAX_VALUE, Integer.MAX_VALUE);
        double d = Numbers.addInt(Integer.MIN_VALUE, Integer.MIN_VALUE);
        System.out.println(x);
        System.out.println(d);
    }
}
