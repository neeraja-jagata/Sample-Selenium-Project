package udemyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import propertiesFileTest.Way2AutomationTest;

public class BootStrapDropdownLec89 {
	
	public static void main(String[] args) {
		Way2AutomationTest obj= new Way2AutomationTest();
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		driver=obj.browserSetUp("firefox");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[.='From']")).click();
		System.out.println("Clicked on from option");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='react-autosuggest__suggestions-list']//*[.='BKK']")).click();
		System.out.println("Clicked on OPtion from list");
		Thread.sleep(2000);
		}catch(WebDriverException e) {
			System.out.println(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
		

	}

}
