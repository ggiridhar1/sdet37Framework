package com.crm.genericUtilitity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class fileUtility {
public String getPropertyvalue(String key) throws Throwable {
	FileInputStream fileInputStream=new FileInputStream(Iconstants.filePathString);
	Properties properties=new Properties();
	properties.load(fileInputStream);
	String value=properties.getProperty(key);
	return value;
}
}
