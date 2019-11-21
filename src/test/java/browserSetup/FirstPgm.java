package browserSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import junit.framework.Assert;


public class FirstPgm {

	public static void main(String[] args)  {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		String expectedTitle= "Amazon";
		String actualTitle= driver.getTitle();
		System.out.println("actualTitle: "+actualTitle);
		//Assert.assertEquals( expectedTitle,actualTitle );
		
		Boolean actualdisplayOfElement= driver.findElement(By.id("nav-logo")).isDisplayed();
		Assert.assertTrue(actualdisplayOfElement);
		System.out.println(actualdisplayOfElement);
		
		String currentUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.amazon.in/" ;
		System.out.println("expectedUrl"+expectedUrl);
		System.out.println("currentUrl"+currentUrl);
		try {
		Assert.assertEquals(currentUrl, expectedUrl);
		System.out.println(" Test Run Successfull");
		driver.close();
		}
		catch (AssertionError e) {

				System.out.println("Assertion Error");
		}
		System.out.println(" Test Run Successfull--------");
		
	

	}

}
