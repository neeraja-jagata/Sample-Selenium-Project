package udemyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardKeys {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		//driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]")).click();
		
		//driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		Actions action=new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();
	
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		action.pause(2000).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.id("identifierId")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		action.pause(10000).perform();
		action.sendKeys(driver.findElement(By.id("identifierId")), Keys.ENTER).perform();;
	
		
		

	}

}
