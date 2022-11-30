package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	Properties p;

	public ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\Manikandaprabu\\eclipse-workspace\\Maven_Amazon\\src\\main\\java\\com\\property\\Test_Data.properties");

		FileInputStream fi = new FileInputStream(f);
		p = new Properties();
		p.load(fi);
	}

	public String getBrowser() {

		String browser = p.getProperty("browser");
		return browser;

	}

	public String getUrlr() {

		String url = p.getProperty("url");
		return url;

	}

	public String getSheet() {
		String sheet = p.getProperty("sheet");
		return sheet;

	}
	
}
