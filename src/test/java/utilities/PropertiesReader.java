package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	private static Properties config;
	static {
		try {
			// The File class from the java.io package, allows us to work with files.
			// To use the File class, create an object of the class,
			// and specify the filename or directory name:
			File file = new File("./src/test/resources/env_variables/env_variboles.properties");
			// input stream for reading data from a File or from a FileDescriptor
			FileInputStream input = new FileInputStream(file);
			config = new Properties();
			config.load(input);
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}
}
