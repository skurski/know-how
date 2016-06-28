package know.how.core.jrunner.essential_classes.test;

import org.junit.Test;

public class NumbersTutor {

	Double d = 123d;
	Integer i = 23545452;
	
	@Test
	public void testConvertNumbers() {
		log("=== testConvertNumbers() ===");
		covertNumbers(i);
		covertNumbers(123d);
		covertNumbers(1239879634342l);
	}
	
	/**
	 * Convert of various number types
	 * @param n
	 */
	public void covertNumbers(Number n) {
		log(n.getClass().getSimpleName()+" n="+n);
		log("n.byteValue()="+n.byteValue());
		log("n.shortValue()="+n.shortValue());
		log("n.intValue()="+n.intValue());
		log("n.longValue()="+n.longValue());
		log("n.doubleValue()="+n.doubleValue());
		log("n.floatValue()="+n.floatValue());
		log("--------------");
	}
	
	/**
	 * Convert from String to various number types
	 * @param s
	 */
	public void stringToNumber(String s) {
		log("=== Convert string "+s+" to Number ===");
		try {
			Byte wrappedByte = new Byte(s);
			log("Byte value="+wrappedByte);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Byte: Bad Number Format: "+s);
		}
		try {
			Short wrappedShort = new Short(s);
			log("Short value="+wrappedShort);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Short: Bad Number Format: "+s);
		}
		try {
			Integer wrappedInt = new Integer(s);
			log("Integer value="+wrappedInt);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Integer: Bad Number Format: "+s);
		}
		try {
			Long wrappedLong = new Long(s);
			log("Long value="+wrappedLong);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Long: Bad Number Format: "+s);
		}
		try {
			Float wrappedFloat = new Float(s);
			log("Float value="+wrappedFloat);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Float: Bad Number Format: "+s);
		}
		try {
			Double wrappedDouble = new Double(s);
			log("Double value="+wrappedDouble);
		} catch (NumberFormatException e) {
			System.out.println("Convert to Double: Bad Number Format: "+s);
		}
	}

	@Test
	public void testStringToNumber() {
		stringToNumber("123");
		stringToNumber("-123");
		stringToNumber("12345678987654321");
		stringToNumber("1.11f");
		stringToNumber("1.1111111111");
	}
	
	/**
	 * Get values Infinite and NaN for Double type
	 */
	@Test
	public void testIsNaN() {
		log("=== testIsNaN() ===");
		log ("Double.isNaN(Math.sqrt(-4)) = "+
				Double.isNaN(Math.sqrt(-4)));
		log ("Double.isInfinite(Double.MAX_VALUE * 2) = "+
				Double.isInfinite(Double.MAX_VALUE * 2));
	}
	
	private void log(String str) {
		System.out.println(str);
	}
}