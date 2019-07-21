package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityFetchproperty {

	public static Object fetchpropertyvalue(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("./config/config.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key);
		
		
	}
	public static String fetchlocatorvalue(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("./config/elements.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key).toString();
		
		
	}
}