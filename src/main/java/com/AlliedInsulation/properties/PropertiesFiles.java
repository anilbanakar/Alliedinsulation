package com.AlliedInsulation.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFiles {
    public static String key;
	public static Properties prop;
	
	public static String configProperties() throws IOException {
		try {
			FileInputStream file = new FileInputStream(new File("/sample/src/test/resources/com/project/properties/config.properties"));
			prop = new Properties();
		 	prop.load(file);
		 	return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
