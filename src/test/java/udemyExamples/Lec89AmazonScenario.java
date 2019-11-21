package udemyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lec89AmazonScenario {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");
		driver.findElement(By.id("nav-search-submit-text")).submit();
		System.out.println("typed headphones and clicked submit button");
		driver.findElement(By.xpath("//*[.='Best Seller']/following::div[@class='sg-row']")).isDisplayed();
		System.out.println("Displayed");
		driver.findElement(By.xpath("//*[.='Best Seller']/following::div[@class='sg-row']//*[@class='sg-col-inner']")).click();
		System.out.println("clicked");
		driver.findElement(By.id("add-to-cart-button")).click();
		System.out.println("clicked Add to cart buton");
		//if(driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']")).isDisplayed()) {
			System.out.println("No coverage ele present");
			driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']")).click();
		//}
		//driver.switchTo().alert().dismiss();
		System.out.println("Dissmiss alert, Added to cart ");
		
		
		
		}catch(WebDriverException e) {
			System.out.println(e);
		} 

	}

}

////*[.='Best Seller']/following::div[@class='sg-row']