package udemyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsOnFlipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Actions action=new Actions(driver);
			driver.get("https://www.flipkart.com/");
			driver.findElement(By.xpath("//div[@class='_3Njdz7']/button[@class='_2AkmmA _29YdH8']")).click();
			action.moveToElement(driver.findElement(By.xpath("//*[@class='_3zdbog _3Ed3Ub']//*[.='Electronics']"))).perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//*[@class='_3zdbog _3Ed3Ub']//*[.='TVs & Appliances']"))).perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//*[@class='_3zdbog _3Ed3Ub']//*[.='Men']"))).perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//*[@class='_3zdbog _3Ed3Ub']//*[.='Women']"))).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='_1QZ6fC _3Lgyp8'][.='Women']/parent::li//a[.='Sarees']")).click();
			int widthOfSlider=driver.findElement(By.className("gl5Kwg")).getSize().width;
			System.out.println(widthOfSlider);
			action.dragAndDropBy(driver.findElement(By.xpath("//*[@class='_3G9WVX _2N3EuE']")),-(widthOfSlider/2), 0).perform();
			System.out.println("Slided");
			
		}catch(WebDriverException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


	}

}
