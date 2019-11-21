package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebsiteLaunch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		try {
			driver.get("https://phptravels.com/demo/");
			String actualTitle= driver.getTitle();
			boolean b= actualTitle.contains("PHPTRAVEL");
			Assert.assertTrue(b);
			
		}
		catch(WebDriverException e){
			System.out.println("exception catched");
			System.out.println(e);			
		}
		catch (AssertionError e) {
			System.out.println("exception catched");
			System.out.println(e);	
		}
		

	}

}
