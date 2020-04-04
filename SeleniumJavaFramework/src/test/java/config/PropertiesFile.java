package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	private static String fileLocation = System.getProperty("user.dir") +"\\src\\test\\java\\config\\config.properties";
	private static Properties prop = new Properties();

	public static String getProperties(String key) {
		String value = null;
		try {
			InputStream input = new FileInputStream(fileLocation);
			prop.load(input);
			value = prop.getProperty(key);
			input.close();
		} 
		catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		} 
		return value;
	}

	public static void setProperties(String key, String value) {

		try {
			InputStream input = new FileInputStream(fileLocation);
			prop.load(input);											// read stream before adding new input so the old data won't be overwritten
			OutputStream output = new FileOutputStream(fileLocation);
			prop.setProperty(key, value);
			prop.store(output,null);
			input.close();
			output.close();

		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}		
	}
}
