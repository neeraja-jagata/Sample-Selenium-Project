package waitsEg;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.common.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		try {
			driver.get("http://gmail.com/");
			Thread.sleep(3000);
			driver.findElement(By.id("identifierId")).sendKeys("abc@gmail.com");
			driver.findElement(By.xpath("//span[(text()='Next')]")).click();
			//driver.findElement(By.xpath("//*[@class='GQ8Pzc']/span")).isDisplayed();
			//System.out.println(driver.findElement(By.xpath("//*[@class='GQ8Pzc']")).getText());
			
			System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='GQ8Pzc']"))).getText());
			//Thread.sleep(3000);
		
		}catch(WebDriverException e) {
			e.printStackTrace();
		}catch ( AssertionError e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
	}

}



