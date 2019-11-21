package udemyAssignments1to3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyLec95Ass1 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("way2automation");
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@class='gNO89b']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[.='www.way2automation.com']")).click();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number Of links: "+links.size());
				
	}

}
