package know.how.testing.datarange;

import java.util.Calendar;

class Number {
	
	short getNumberYears(short start, short end) {
		short res = (short) (end + start);
		return res;
	}
	
	public static void main(String[] args) {
//		byte b = -128;
//		short s = 32768;
//		int x = 70000;
		
		Number num = new Number();
		short a = 3000;
		short b = 32000;
		short s = num.getNumberYears(a,b);
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
	     Calendar calendar1 = Calendar.getInstance();
	      Calendar calendar2 = Calendar.getInstance();
	      calendar1.set(1967, 04, 02);
	      calendar2.set(1971, 01, 01);
	      long milsecs1= calendar1.getTimeInMillis();
	      long milsecs2 = calendar2.getTimeInMillis();
	      long diff = milsecs2 - milsecs1;
	      long dsecs = diff / 1000;
	      long dminutes = diff / (60 * 1000);
	      long dhours = diff / (60 * 60 * 1000);
	      long ddays = diff / (24 * 60 * 60 * 1000);
	      
			System.out.println(milsecs1 / (1000 * 60 * 60 *24));
			System.out.println(milsecs2/ (1000 * 60 * 60 *24));


	      System.out.println("Your Day Difference="+ddays);

	}
}
