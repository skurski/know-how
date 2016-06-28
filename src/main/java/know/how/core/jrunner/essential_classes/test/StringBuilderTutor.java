package know.how.core.jrunner.essential_classes.test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class StringBuilderTutor {

	String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant",
        "Rabbit", "Snake", "Chicken", "Horse", "Human"};

	/**
	 * Method must return a string: 
	 * "Animal list: Cow, Goose, ..., Human."
	 * For implementation use StringBuilder
	 */
	public String getAnimalsString() {
		StringBuilder sb = new StringBuilder("Animal list: ");
		for (String str: animals) {
			sb.append(str);
			sb.append(", ");
		}
		sb.replace(sb.length()-2, sb.length(), ".");
		return sb.toString();
	}
	
	@Test
	public void testGetAnimalsString() {
		String animalsString = getAnimalsString();
		assertEquals("Animal list: Cow, Goose, Cat, Dog, Elephant, "+
		    "Rabbit, Snake, Chicken, Horse, Human.", animalsString);
	}
	
}
