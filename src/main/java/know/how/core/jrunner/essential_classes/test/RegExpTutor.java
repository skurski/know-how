package know.how.core.jrunner.essential_classes.test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RegExpTutor {

	class Email {
		String name;
		String domainName;
		String domainZone;
	}
	
	public Email getEmail(String emailString) {
		String[] emailArr = emailString.split("@");
		String[] domainArr = emailArr[1].split("\\.");
		
		Email email = new Email();
		email.name = emailArr[0];
		email.domainName = domainArr[0];
		email.domainZone = domainArr[1];
		
		return email;
	}
	
	/**
    * Returns a list of lines by text representation of the lines.
    * Takes a string
    * "List of animals: cow, goose, cat, dog, elephant, rabbit, 
    * snake, chicken, horse, human."
    * And returns an array of animals
    */
	public String[] getAnimalsArray(String animalsString) {
		String animal = animalsString.replaceAll("([a-zA-Z ]+: )|(,)|(\\.)|([ ]+)", " ").trim();
		String[] animalArr = animal.split("[ ]+");
		
		return animalArr;
	}
	
	@Test
	public void testGetEmail() {
		Email email = getEmail("ivanov@mail.ru");
		assertEquals("ivanov", email.name);
		assertEquals("mail", email.domainName);
		assertEquals("ru", email.domainZone);
		
	}
	
	@Test
	public void testGetAnimalsArray() {
		String [] animals =
            {"Cow", "Goose", "Cat", "Dog", "Elephant",
            "Rabbit", "Snake", "Chicken", "Horse", "Human"};
            String animalsString = 
                "List of animals: Cow, Goose, Cat, Dog, Elephant," +
                "Rabbit, Snake, Chicken, Horse, Human.";
            assertArrayEquals(animals, getAnimalsArray(animalsString));
	}

}
