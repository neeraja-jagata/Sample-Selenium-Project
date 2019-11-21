package udemyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.get("https://test-entrynew.firebaseapp.com/");
		driver.findElement(By.name("email")).sendKeys("abc");
		//driver.findElement(By.id("labelAndInputContainer")).sendKeys("abc");  */
		
		driver.get("https://www.facebook.com");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com"); //sending username

		Actions action = new Actions(driver);
		/*action.sendKeys(Keys.chord(Keys.CONTROL+"a"))
		.sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();*/
		//.sendKeys(Keys.TAB).build().perform();

		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		
		
		driver.findElement(By.xpath("//input[@id='pass']")).click();;

		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		
	}

}
