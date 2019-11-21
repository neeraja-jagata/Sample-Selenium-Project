package propertiesFileTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleTest {

	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\Neeraja\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\propertiesFileTest\\object.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\propertiesFileTest\\object.properties");
		prop.load(fis);
		//System.getProperty("name");
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		//System.out.println(System.getProperties());
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\propertiesTest\\object.properties");
 
		//WebDriver driver = new RemoteWebDriver();
		
		fis.close();
	}

}
