package know.how.testing.assertion;

public class AssertTest {
	
	public int calc(int x, int y) {
		int result =  x + y;
		assert result < 0 : "not correct numbers";
		return result;
	}
	
	public static void main(String[] args) {
		AssertTest as = new AssertTest();
		as.calc(-5, -7);
		
//        PassA p = new PassA();
//        p.start();
        
//        Float f1 = new Float("3.33");
//        int x = f1.intValue();
//        byte b = f1.byteValue();
//        double d = f1.doubleValue();
//        System.out.println(x + b + d + " ");
        
        int z,x=5,y=-10,a=4,b=2; 
        z = x++ - --y * b / a; 
        System.out.println(z);
        
	}
}

class PassA 
{

    void start() 
    {
        long [] a1 = {3,4,5};
        long [] a2 = fix(a1);
        System.out.print(a1[0] + a1[1] + a1[2] + " ");
        System.out.println(a2[0] + a2[1] + a2[2]);
    }

    long [] fix(long [] a3) 
    {
        a3[1] = 7;
        return a3;
    }
}
