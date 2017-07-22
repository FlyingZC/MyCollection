package com.zc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public void test01() throws FileNotFoundException, IOException{
		Properties properties=new Properties();
		//load一个流(InputStream或者Reader)
		properties.load(new FileInputStream(new File("jdbc.properties")));
		String user=properties.getProperty("user");
	}
}
