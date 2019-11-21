package propertiesFileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Way2AutomationTest {
	static WebDriver driver;
	Properties prop;
	FileInputStream fis;
	File propertiesFile;
	String path=System.getProperty("user.dir")+"\\src\\test\\java\\propertiesFileTest\\object.properties";
	static String Way2AutomationUrl="http://www.way2automation.com/";
	public static void main(String[] args) {
		Way2AutomationTest obj= new Way2AutomationTest();
		try {
		driver=obj.browserSetUp("chrome");
		obj.OpenWebsite(Way2AutomationUrl);
		obj.VerifyBasePage();
		} catch (InterruptedException e ) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}		catch(WebDriverException e) {
			e.printStackTrace();
		}catch ( AssertionError e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	public  WebDriver browserSetUp(String browser){
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
			 driver=new ChromeDriver();
			 return driver;
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Neeraja\\Documents\\java\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 return driver;
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\Neeraja\\Documents\\java\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 return driver;
		}
		else{
			System.out.println("Browser specified is not correct");
			System.out.println("invocking default browser ie., Chrome browser");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
			 driver=new ChromeDriver();
			 return driver;
		}
	}
	
	public void OpenWebsite(String url) throws InterruptedException {
		driver.get(Way2AutomationUrl);
			Thread.sleep(2000);
		driver.manage().window().maximize();
			Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), Way2AutomationUrl);
		System.out.println("Web page opened and asserted url");
	}

	public void VerifyBasePage() throws IOException {
		 prop=new Properties();
		 propertiesFile= new File(path);
		//FileInputStream fis=new FileInputStream("C:\\Users\\Neeraja\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\propertiesFileTest\\object.properties");
		//fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\propertiesFileTest\\object.properties");
		 fis= new FileInputStream(propertiesFile);
		prop.load(fis);
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("menberLoginButton"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("buyNowButton"))).isDisplayed());
		System.out.println("MemberLogin Button and buyNow Button are present");
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("homeButton"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("aboutUsButton"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("classRoomTrainingDD"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("seleniumDropDown"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("appiumDropDown"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("protractorDropDown"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("resourcesDropDown"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("videoTutorialsDD"))).isDisplayed());
		System.out.println("All buttons and dropdowns are present on the header");
		
		fis.close();
	}

}
