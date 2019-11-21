package udemyExamples;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neeraja\\Documents\\java\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement img = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
	
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		action.moveToElement(driver.findElement(By.id("dm2m1i1tdT"))).perform();
		action.moveToElement(driver.findElement(By.id("dm2m2i1tdT"))).perform();
		action.click(driver.findElement(By.id("dm2m3i1tdT"))).perform();
		
		Set<String> windows=driver.getWindowHandles();
		for (String string : windows) {
			System.out.println(string);
		}
		Iterator<String> itr=windows.iterator();
		String mainwin=itr.next();
		String win2=itr.next();
		driver.switchTo().window(win2);
		System.out.println(win2);
		Assert.assertEquals(driver.getCurrentUrl(), "http://deluxe-menu.com/installation-info.html");
		System.out.println("Asserted");
		driver.close();
		driver.switchTo().window(mainwin);
		System.out.println(driver.getCurrentUrl());
		

	}

}
