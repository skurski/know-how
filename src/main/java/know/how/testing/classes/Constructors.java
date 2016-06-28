package know.how.testing.classes;

/*
 * Constructors cannot be inherited
 * It can be called from subclass
 * 
 * Default constructors are created only if there is no 
 * other constructors defined in class
 * 
 * Subclass always call super class non-arg (default) constructor
 */
class A 
{ 
	public A() {
		System.out.println("A");
	}
    public A(int x){
    	System.out.println("A - arg");
    } 
}

class B extends A 
{
	public B() {
		System.out.println("C");
	}
	
	public B(int x) {
		System.out.println("B - arg");
	}
}

class C extends B
{
	private int z;
	
	public C(int x) {
		System.out.println("C - arg");
	}
}

public class Constructors 
{ 
    public static void main (String args []) 
    {
    	int x = 10;
        A a = new C(10); 
        System.out.println("complete"); 
    } 
}
