package know.how.core.jrunner.essential_classes.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertiesTutor {

	/**
	 * Returns the value of system property java.version
	 */
	public String getJavaVersion() {
		return System.getProperty("java.runtime.version");
	}
	
	@Test
	public void testJavaVersion() {
		String version = getJavaVersion();
		log(getJavaVersion());
		assertTrue(version.startsWith("1."));
	}

	/**
	 * Loads properties-file from folder files/props.properties 
	 * and returns the loaded properties  
	 * @return
	 */
	public Properties getProperties() {
		Properties prop = new Properties();
		try {
			InputStream in = new FileInputStream("files/props.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	@Test
	public void testGetProperties() {
		Properties props = getProperties();
		log("country="+props.getProperty("country"));
		log("color="+props.getProperty("color"));
		assertEquals("Australia", props.getProperty("country"));
		assertEquals("red", props.getProperty("color"));
	}
	
	private void log(String str) {
		System.out.println(str);
	}
}

