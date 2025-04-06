package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.constants.Environment;

public class PropertiesUtil {
	//read properties file
	
	public static String readProperty(Environment environment, String propertyName) {
		
		System.out.println(System.getProperty("user.dir"));
		
		File propFile = Paths.get(System.getProperty("user.dir"), "Config", environment + ".properties").toFile();
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
	}
}
